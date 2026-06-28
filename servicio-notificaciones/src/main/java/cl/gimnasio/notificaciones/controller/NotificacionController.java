package cl.gimnasio.notificaciones.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.notificaciones.dto.NotificacionDTO;
import cl.gimnasio.notificaciones.service.NotificacionService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notificaciones")
@RequiredArgsConstructor
public class NotificacionController {

    private final NotificacionService notificacionService;

    @GetMapping
    public ResponseEntity<List<NotificacionDTO>> getAllNotificaciones() {
        return ResponseEntity.ok(notificacionService.getAllNotificaciones().stream().map(NotificacionDTO::fromModel).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacionDTO> getNotificacionById(@PathVariable Long id) {
        return ResponseEntity.ok(NotificacionDTO.fromModel(notificacionService.getNotificacionById(id)));
    }

    @Hidden
    @GetMapping("/socio/{socioId}")
    public ResponseEntity<List<NotificacionDTO>> getNotificacionesBySocioId(@PathVariable Long socioId) {
        return ResponseEntity.ok(notificacionService.getNotificacionesBySocioId(socioId).stream().map(NotificacionDTO::fromModel).toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NotificacionDTO createNotificacion(@Valid @RequestBody NotificacionDTO notificacion) {
        return NotificacionDTO.fromModel(notificacionService.createNotificacion(notificacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacionDTO> updateNotificacion(@PathVariable Long id, @Valid @RequestBody NotificacionDTO notificacion) {
        return ResponseEntity.ok(NotificacionDTO.fromModel(notificacionService.updateNotificacion(id, notificacion)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotificacion(@PathVariable Long id) {
        notificacionService.deleteNotificacion(id);
        return ResponseEntity.noContent().build();
    }
}
