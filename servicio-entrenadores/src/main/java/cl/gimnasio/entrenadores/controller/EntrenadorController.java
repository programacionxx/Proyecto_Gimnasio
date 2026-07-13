package cl.gimnasio.entrenadores.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger log = LoggerFactory.getLogger(EntrenadorController.class);

    private final EntrenadorService entrenadorService;

    @PostMapping
    public ResponseEntity<EntrenadorDTO> createEntrenador(@Valid @RequestBody EntrenadorDTO request) {
        log.info("Ejecutando createEntrenador en EntrenadorController");
        return ResponseEntity.ok(EntrenadorDTO.fromModel(entrenadorService.createEntrenador(request)));
    }

    @GetMapping
    public ResponseEntity<List<EntrenadorDTO>> getAllEntrenadores() {
        log.info("Ejecutando getAllEntrenadores en EntrenadorController");
        return ResponseEntity.ok(entrenadorService.getAllEntrenadores().stream().map(EntrenadorDTO::fromModel).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntrenadorDTO> getEntrenadorById(@PathVariable Long id) {
        log.info("Ejecutando getEntrenadorById en EntrenadorController");
        return ResponseEntity.ok(EntrenadorDTO.fromModel(entrenadorService.getEntrenadorById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntrenadorDTO> updateEntrenador(@PathVariable Long id, @Valid @RequestBody EntrenadorDTO request) {
        log.info("Ejecutando updateEntrenador en EntrenadorController");
        return ResponseEntity.ok(EntrenadorDTO.fromModel(entrenadorService.updateEntrenador(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntrenador(@PathVariable Long id) {
        log.warn("Ejecutando deleteEntrenador en EntrenadorController");
        entrenadorService.deleteEntrenador(id);
        return ResponseEntity.noContent().build();
    }
}
