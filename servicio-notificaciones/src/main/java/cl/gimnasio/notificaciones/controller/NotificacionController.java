package cl.gimnasio.notificaciones.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger log = LoggerFactory.getLogger(NotificacionController.class);

    private final NotificacionService notificacionService;

    @GetMapping
    public ResponseEntity<List<NotificacionDTO>> getAllNotificaciones() {
        log.info("Ejecutando getAllNotificaciones en NotificacionController");
        return ResponseEntity.ok(notificacionService.getAllNotificaciones().stream().map(NotificacionDTO::fromModel).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificacionDTO> getNotificacionById(@PathVariable Long id) {
        log.info("Ejecutando getNotificacionById en NotificacionController");
        return ResponseEntity.ok(NotificacionDTO.fromModel(notificacionService.getNotificacionById(id)));
    }

    @Hidden
    @GetMapping("/socio/{socioId}")
    public ResponseEntity<List<NotificacionDTO>> getNotificacionesBySocioId(@PathVariable Long socioId) {
        log.info("Ejecutando getNotificacionesBySocioId en NotificacionController");
        return ResponseEntity.ok(notificacionService.getNotificacionesBySocioId(socioId).stream().map(NotificacionDTO::fromModel).toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NotificacionDTO createNotificacion(@Valid @RequestBody NotificacionDTO notificacion) {
        log.info("Ejecutando createNotificacion en NotificacionController");
        return NotificacionDTO.fromModel(notificacionService.createNotificacion(notificacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotificacionDTO> updateNotificacion(@PathVariable Long id, @Valid @RequestBody NotificacionDTO notificacion) {
        log.info("Ejecutando updateNotificacion en NotificacionController");
        return ResponseEntity.ok(NotificacionDTO.fromModel(notificacionService.updateNotificacion(id, notificacion)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotificacion(@PathVariable Long id) {
        log.warn("Ejecutando deleteNotificacion en NotificacionController");
        notificacionService.deleteNotificacion(id);
        return ResponseEntity.noContent().build();
    }
}
