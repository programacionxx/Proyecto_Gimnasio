package cl.gimnasio.inventario.controller;

import java.util.List;

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

    private final InventarioService inventarioService;

    @GetMapping
    public ResponseEntity<List<InventarioDTO>> getAllInventario() {
        return ResponseEntity.ok(inventarioService.getAllInventario().stream().map(InventarioDTO::fromModel).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventarioDTO> getInventarioById(@PathVariable Long id) {
        return ResponseEntity.ok(InventarioDTO.fromModel(inventarioService.getInventarioById(id)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventarioDTO createInventario(@Valid @RequestBody InventarioDTO inventario) {
        return InventarioDTO.fromModel(inventarioService.createInventario(inventario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventarioDTO> updateInventario(@PathVariable Long id, @Valid @RequestBody InventarioDTO inventario) {
        return ResponseEntity.ok(InventarioDTO.fromModel(inventarioService.updateInventario(id, inventario)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventario(@PathVariable Long id) {
        inventarioService.deleteInventario(id);
        return ResponseEntity.noContent().build();
    }
}
