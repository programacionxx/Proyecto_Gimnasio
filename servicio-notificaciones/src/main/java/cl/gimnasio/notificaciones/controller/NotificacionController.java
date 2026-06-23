package cl.gimnasio.notificaciones.controller;

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

import cl.gimnasio.notificaciones.entity.Notificacion;
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
    public ResponseEntity<List<Notificacion>> getAllNotificaciones() {
        return ResponseEntity.ok(notificacionService.getAllNotificaciones());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> getNotificacionById(@PathVariable Long id) {
        return ResponseEntity.ok(notificacionService.getNotificacionById(id));
    }

    @Hidden
    @GetMapping("/socio/{socioId}")
    public ResponseEntity<List<Notificacion>> getNotificacionesBySocioId(@PathVariable Long socioId) {
        return ResponseEntity.ok(notificacionService.getNotificacionesBySocioId(socioId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Notificacion createNotificacion(@Valid @RequestBody Notificacion notificacion) {
        return notificacionService.createNotificacion(notificacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notificacion> updateNotificacion(@PathVariable Long id, @Valid @RequestBody Notificacion notificacion) {
        return ResponseEntity.ok(notificacionService.updateNotificacion(id, notificacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotificacion(@PathVariable Long id) {
        notificacionService.deleteNotificacion(id);
        return ResponseEntity.noContent().build();
    }
}
