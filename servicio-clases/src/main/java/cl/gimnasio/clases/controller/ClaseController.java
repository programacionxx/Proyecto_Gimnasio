package cl.gimnasio.clases.controller;

import cl.gimnasio.clases.dto.ClaseDTO;
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
    public ResponseEntity<ClaseDTO> createClase(@Valid @RequestBody ClaseDTO request) {
        return ResponseEntity.ok(ClaseDTO.fromModel(claseService.createClase(request)));
    }

    @GetMapping
    public ResponseEntity<List<ClaseDTO>> getAllClases() {
        return ResponseEntity.ok(claseService.getAllClases().stream().map(ClaseDTO::fromModel).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaseDTO> getClaseById(@PathVariable Long id) {
        return ResponseEntity.ok(ClaseDTO.fromModel(claseService.getClaseById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaseDTO> updateClase(@PathVariable Long id, @Valid @RequestBody ClaseDTO request) {
        return ResponseEntity.ok(ClaseDTO.fromModel(claseService.updateClase(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClase(@PathVariable Long id) {
        claseService.deleteClase(id);
        return ResponseEntity.noContent().build();
    }
}
