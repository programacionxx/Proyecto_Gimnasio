package cl.gimnasio.reservas.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.reservas.assemblers.ReservaModelAssembler;
import cl.gimnasio.reservas.dto.ReservaDTO;
import cl.gimnasio.reservas.exception.ReservaNotFoundException;
import cl.gimnasio.reservas.service.ReservaService;

@RestController
@RequestMapping("/api/reservas/v2")
public class ReservaControllerV2 {

    private final ReservaService reservaService;
    private final ReservaModelAssembler assembler;

    public ReservaControllerV2(ReservaService reservaService, ReservaModelAssembler assembler) {
        this.reservaService = reservaService;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<ReservaDTO>> getAllReservas() {
        List<EntityModel<ReservaDTO>> reservas = reservaService.findAll().stream()
                .map(ReservaDTO::fromModel)
                .map(assembler::toModel)
                .toList();
        return CollectionModel.of(reservas, linkTo(methodOn(ReservaControllerV2.class).getAllReservas()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<ReservaDTO> getReservaById(@PathVariable Long id) {
        ReservaDTO reserva = ReservaDTO.fromModel(reservaService.findById(id)
                .orElseThrow(() -> new ReservaNotFoundException(id)));
        return assembler.toModel(reserva);
    }

}
