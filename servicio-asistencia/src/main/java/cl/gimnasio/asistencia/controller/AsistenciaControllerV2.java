package cl.gimnasio.asistencia.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.asistencia.assemblers.AsistenciaModelAssembler;
import cl.gimnasio.asistencia.dto.AsistenciaDTO;
import cl.gimnasio.asistencia.service.AsistenciaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/asistencias/v2")
@RequiredArgsConstructor
public class AsistenciaControllerV2 {

    private static final Logger log = LoggerFactory.getLogger(AsistenciaControllerV2.class);

    private final AsistenciaService asistenciaService;
    private final AsistenciaModelAssembler assembler;


    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<AsistenciaDTO>>> all() {
        log.info("Ejecutando all en AsistenciaControllerV2");
        List<EntityModel<AsistenciaDTO>> asistencias = asistenciaService.getAllAsistencias().stream()
                .map(AsistenciaDTO::fromModel)
                .map(assembler::toModel)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(asistencias, linkTo(methodOn(AsistenciaControllerV2.class).all()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<AsistenciaDTO>> one(@PathVariable Long id) {
        log.info("Ejecutando one en AsistenciaControllerV2");
        AsistenciaDTO asistencia = AsistenciaDTO.fromModel(asistenciaService.getAsistenciaById(id));
        return ResponseEntity.ok(assembler.toModel(asistencia));
    }


}
