package cl.gimnasio.clases.controller;

import cl.gimnasio.clases.assemblers.ClaseModelAssembler;
import cl.gimnasio.clases.dto.ClaseDTO;
import cl.gimnasio.clases.service.ClaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases/v2")
@RequiredArgsConstructor
public class ClaseControllerV2 {

    private static final Logger log = LoggerFactory.getLogger(ClaseControllerV2.class);

    private final ClaseService claseService;
    private final ClaseModelAssembler assembler;


    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<ClaseDTO>>> getAllClases() {
        log.info("Ejecutando getAllClases en ClaseControllerV2");
        List<EntityModel<ClaseDTO>> clases = claseService.getAllClases().stream()
                .map(ClaseDTO::fromModel)
                .map(assembler::toModel)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(clases, linkTo(methodOn(ClaseControllerV2.class).getAllClases()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ClaseDTO>> getClaseById(@PathVariable Long id) {
        log.info("Ejecutando getClaseById en ClaseControllerV2");
        ClaseDTO clase = ClaseDTO.fromModel(claseService.getClaseById(id));
        return ResponseEntity.ok(assembler.toModel(clase));
    }


}
