package cl.gimnasio.entrenadores.controller;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.entrenadores.assemblers.EntrenadorModelAssembler;
import cl.gimnasio.entrenadores.dto.EntrenadorDTO;
import cl.gimnasio.entrenadores.service.EntrenadorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/entrenadores/v2")
@RequiredArgsConstructor
public class EntrenadorControllerV2 {

    private final EntrenadorService entrenadorService;
    private final EntrenadorModelAssembler assembler;


    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<EntrenadorDTO>>> getAllEntrenadores() {
        List<EntityModel<EntrenadorDTO>> entrenadores = entrenadorService.getAllEntrenadores().stream()
                .map(EntrenadorDTO::fromModel)
                .map(assembler::toModel)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(entrenadores, linkTo(methodOn(EntrenadorControllerV2.class).getAllEntrenadores()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<EntrenadorDTO>> getEntrenadorById(@PathVariable Long id) {
        EntrenadorDTO entrenador = EntrenadorDTO.fromModel(entrenadorService.getEntrenadorById(id));
        return ResponseEntity.ok(assembler.toModel(entrenador));
    }


}
