package cl.gimnasio.socios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.socios.assemblers.SocioModelAssembler;
import cl.gimnasio.socios.dto.SocioDTO;
import cl.gimnasio.socios.service.SocioService;

@RestController
@RequestMapping("/api/socios/v2")
public class SocioControllerV2 {

    @Autowired
    private SocioService socioService;

    @Autowired
    private SocioModelAssembler assembler;


    @GetMapping
    public CollectionModel<EntityModel<SocioDTO>> listarSocios() {
        List<EntityModel<SocioDTO>> socios = socioService.listarSocios().stream()
                .map(SocioDTO::fromModel)
                .map(assembler::toModel)
                .toList();
        return CollectionModel.of(socios, linkTo(methodOn(SocioControllerV2.class).listarSocios()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<SocioDTO> obtenerSocio(@PathVariable Long id) {
        SocioDTO socio = SocioDTO.fromModel(socioService.obtenerPorId(id));
        return assembler.toModel(socio);
    }


}
