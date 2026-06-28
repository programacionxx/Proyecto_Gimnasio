package cl.gimnasio.membresias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.membresias.assemblers.MembresiaModelAssembler;
import cl.gimnasio.membresias.dto.MembresiaDTO;
import cl.gimnasio.membresias.service.MembresiaService;

@RestController
@RequestMapping("/api/membresias/v2")
public class MembresiaControllerV2 {

    @Autowired
    private MembresiaService membresiaService;

    @Autowired
    private MembresiaModelAssembler assembler;


    @GetMapping
    public CollectionModel<EntityModel<MembresiaDTO>> listarMembresias() {
        List<EntityModel<MembresiaDTO>> membresias = membresiaService.listarMembresias().stream()
                .map(MembresiaDTO::fromModel)
                .map(assembler::toModel)
                .toList();
        return CollectionModel.of(membresias, linkTo(methodOn(MembresiaControllerV2.class).listarMembresias()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<MembresiaDTO> obtenerMembresia(@PathVariable Long id) {
        MembresiaDTO membresia = MembresiaDTO.fromModel(membresiaService.obtenerPorId(id));
        return assembler.toModel(membresia);
    }


}
