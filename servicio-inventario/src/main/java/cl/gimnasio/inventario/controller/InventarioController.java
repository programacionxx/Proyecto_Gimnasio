package cl.gimnasio.inventario.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.gimnasio.inventario.entity.Inventario;
import cl.gimnasio.inventario.service.InventarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventario")
@RequiredArgsConstructor
public class InventarioController {

    private final InventarioService inventarioService;

    @GetMapping
    public ResponseEntity<List<Inventario>> getAllInventario() {
        return ResponseEntity.ok(inventarioService.getAllInventario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> getInventarioById(@PathVariable Long id) {
        return ResponseEntity.ok(inventarioService.getInventarioById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Inventario createInventario(@Valid @RequestBody Inventario inventario) {
        return inventarioService.createInventario(inventario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventario> updateInventario(@PathVariable Long id, @Valid @RequestBody Inventario inventario) {
        return ResponseEntity.ok(inventarioService.updateInventario(id, inventario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventario(@PathVariable Long id) {
        inventarioService.deleteInventario(id);
        return ResponseEntity.noContent().build();
    }
}
