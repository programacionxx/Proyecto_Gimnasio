package cl.gimnasio.inventario.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.inventario.dto.InventarioDTO;
import cl.gimnasio.inventario.service.InventarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventario")
@RequiredArgsConstructor
public class InventarioController {

    private static final Logger log = LoggerFactory.getLogger(InventarioController.class);

    private final InventarioService inventarioService;

    @GetMapping
    public ResponseEntity<List<InventarioDTO>> getAllInventario() {
        log.info("Ejecutando getAllInventario en InventarioController");
        return ResponseEntity.ok(inventarioService.getAllInventario().stream().map(InventarioDTO::fromModel).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventarioDTO> getInventarioById(@PathVariable Long id) {
        log.info("Ejecutando getInventarioById en InventarioController");
        return ResponseEntity.ok(InventarioDTO.fromModel(inventarioService.getInventarioById(id)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventarioDTO createInventario(@Valid @RequestBody InventarioDTO inventario) {
        log.info("Ejecutando createInventario en InventarioController");
        return InventarioDTO.fromModel(inventarioService.createInventario(inventario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventarioDTO> updateInventario(@PathVariable Long id, @Valid @RequestBody InventarioDTO inventario) {
        log.info("Ejecutando updateInventario en InventarioController");
        return ResponseEntity.ok(InventarioDTO.fromModel(inventarioService.updateInventario(id, inventario)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventario(@PathVariable Long id) {
        log.warn("Ejecutando deleteInventario en InventarioController");
        inventarioService.deleteInventario(id);
        return ResponseEntity.noContent().build();
    }
}
