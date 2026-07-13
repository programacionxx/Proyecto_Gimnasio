package cl.gimnasio.entrenadores.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger log = LoggerFactory.getLogger(EntrenadorControllerV2.class);

    private final EntrenadorService entrenadorService;
    private final EntrenadorModelAssembler assembler;


    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<EntrenadorDTO>>> getAllEntrenadores() {
        log.info("Ejecutando getAllEntrenadores en EntrenadorControllerV2");
        List<EntityModel<EntrenadorDTO>> entrenadores = entrenadorService.getAllEntrenadores().stream()
                .map(EntrenadorDTO::fromModel)
                .map(assembler::toModel)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(entrenadores, linkTo(methodOn(EntrenadorControllerV2.class).getAllEntrenadores()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<EntrenadorDTO>> getEntrenadorById(@PathVariable Long id) {
        log.info("Ejecutando getEntrenadorById en EntrenadorControllerV2");
        EntrenadorDTO entrenador = EntrenadorDTO.fromModel(entrenadorService.getEntrenadorById(id));
        return ResponseEntity.ok(assembler.toModel(entrenador));
    }


}
