package cl.gimnasio.inventario.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.inventario.assemblers.InventarioModelAssembler;
import cl.gimnasio.inventario.dto.InventarioDTO;
import cl.gimnasio.inventario.service.InventarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventario/v2")
@RequiredArgsConstructor
public class InventarioControllerV2 {

    private static final Logger log = LoggerFactory.getLogger(InventarioControllerV2.class);

    private final InventarioService inventarioService;
    private final InventarioModelAssembler assembler;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<InventarioDTO>>> getAllInventario() {
        log.info("Ejecutando getAllInventario en InventarioControllerV2");
        List<EntityModel<InventarioDTO>> inventario = inventarioService.getAllInventario().stream()
                .map(InventarioDTO::fromModel)
                .map(assembler::toModel)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(inventario, linkTo(methodOn(InventarioControllerV2.class).getAllInventario()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<InventarioDTO>> getInventarioById(@PathVariable Long id) {
        log.info("Ejecutando getInventarioById en InventarioControllerV2");
        InventarioDTO inventario = InventarioDTO.fromModel(inventarioService.getInventarioById(id));
        return ResponseEntity.ok(assembler.toModel(inventario));
    }



}
