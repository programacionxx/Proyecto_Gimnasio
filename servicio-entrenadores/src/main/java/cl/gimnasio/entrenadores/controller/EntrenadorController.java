package cl.gimnasio.entrenadores.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.entrenadores.dto.EntrenadorDTO;
import cl.gimnasio.entrenadores.service.EntrenadorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/entrenadores")
@RequiredArgsConstructor
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    @PostMapping
    public ResponseEntity<EntrenadorDTO> createEntrenador(@Valid @RequestBody EntrenadorDTO request) {
        return ResponseEntity.ok(EntrenadorDTO.fromModel(entrenadorService.createEntrenador(request)));
    }

    @GetMapping
    public ResponseEntity<List<EntrenadorDTO>> getAllEntrenadores() {
        return ResponseEntity.ok(entrenadorService.getAllEntrenadores().stream().map(EntrenadorDTO::fromModel).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntrenadorDTO> getEntrenadorById(@PathVariable Long id) {
        return ResponseEntity.ok(EntrenadorDTO.fromModel(entrenadorService.getEntrenadorById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntrenadorDTO> updateEntrenador(@PathVariable Long id, @Valid @RequestBody EntrenadorDTO request) {
        return ResponseEntity.ok(EntrenadorDTO.fromModel(entrenadorService.updateEntrenador(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntrenador(@PathVariable Long id) {
        entrenadorService.deleteEntrenador(id);
        return ResponseEntity.noContent().build();
    }
}
