package cl.gimnasio.entrenadores.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.gimnasio.entrenadores.EntrenadorRequest;
import cl.gimnasio.entrenadores.entity.Entrenador;
import cl.gimnasio.entrenadores.service.EntrenadorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/entrenadores")
@RequiredArgsConstructor
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    @PostMapping
    public ResponseEntity<Entrenador> createEntrenador(@Valid @RequestBody EntrenadorRequest request) {
        return ResponseEntity.ok(entrenadorService.createEntrenador(request));
    }

    @GetMapping
    public ResponseEntity<List<Entrenador>> getAllEntrenadores() {
        return ResponseEntity.ok(entrenadorService.getAllEntrenadores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> getEntrenadorById(@PathVariable Long id) {
        return ResponseEntity.ok(entrenadorService.getEntrenadorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> updateEntrenador(@PathVariable Long id, @Valid @RequestBody EntrenadorRequest request) {
        return ResponseEntity.ok(entrenadorService.updateEntrenador(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntrenador(@PathVariable Long id) {
        entrenadorService.deleteEntrenador(id);
        return ResponseEntity.noContent().build();
    }
}
