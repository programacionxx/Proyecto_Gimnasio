package cl.gimnasio.asistencia.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.asistencia.dto.AsistenciaDTO;
import cl.gimnasio.asistencia.service.AsistenciaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/asistencias")
@RequiredArgsConstructor
public class AsistenciaController {

    private final AsistenciaService asistenciaService;

    @PostMapping
    public ResponseEntity<AsistenciaDTO> create(@Valid @RequestBody AsistenciaDTO r) {
        return ResponseEntity.ok(AsistenciaDTO.fromModel(asistenciaService.createAsistencia(r)));
    }

    @GetMapping
    public ResponseEntity<List<AsistenciaDTO>> all() {
        return ResponseEntity.ok(asistenciaService.getAllAsistencias().stream().map(AsistenciaDTO::fromModel).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsistenciaDTO> one(@PathVariable Long id) {
        return ResponseEntity.ok(AsistenciaDTO.fromModel(asistenciaService.getAsistenciaById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsistenciaDTO> update(@PathVariable Long id, @Valid @RequestBody AsistenciaDTO r) {
        return ResponseEntity.ok(AsistenciaDTO.fromModel(asistenciaService.updateAsistencia(id, r)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        asistenciaService.deleteAsistencia(id);
        return ResponseEntity.noContent().build();
    }
}
