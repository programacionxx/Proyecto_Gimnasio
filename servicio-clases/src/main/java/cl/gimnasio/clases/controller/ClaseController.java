package cl.gimnasio.clases.controller;

import cl.gimnasio.clases.entity.Clase;
import cl.gimnasio.clases.model.ClaseRequest;
import cl.gimnasio.clases.service.ClaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
@RequiredArgsConstructor
public class ClaseController {

    private final ClaseService claseService;

    @PostMapping
    public ResponseEntity<Clase> createClase(@Valid @RequestBody ClaseRequest request) {
        return ResponseEntity.ok(claseService.createClase(request));
    }

    @GetMapping
    public ResponseEntity<List<Clase>> getAllClases() {
        return ResponseEntity.ok(claseService.getAllClases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clase> getClaseById(@PathVariable Long id) {
        return ResponseEntity.ok(claseService.getClaseById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clase> updateClase(@PathVariable Long id, @Valid @RequestBody ClaseRequest request) {
        return ResponseEntity.ok(claseService.updateClase(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClase(@PathVariable Long id) {
        claseService.deleteClase(id);
        return ResponseEntity.noContent().build();
    }
}
