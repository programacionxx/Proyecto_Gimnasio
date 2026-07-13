package cl.gimnasio.notificaciones.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import cl.gimnasio.notificaciones.dto.NotificacionDTO;
import cl.gimnasio.notificaciones.entity.Notificacion;
import cl.gimnasio.notificaciones.exception.ResourceNotFoundException;
import cl.gimnasio.notificaciones.repository.NotificacionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificacionService {

    private static final Logger log = LoggerFactory.getLogger(NotificacionService.class);

    private final NotificacionRepository notificacionRepository;

    public Notificacion createNotificacion(NotificacionDTO notificacion) {
        log.info("Ejecutando createNotificacion en NotificacionService");
        return notificacionRepository.save(notificacion.toModel());
    }

    public List<Notificacion> getAllNotificaciones() {
        log.info("Ejecutando getAllNotificaciones en NotificacionService");
        return notificacionRepository.findAll();
    }

    public Notificacion getNotificacionById(Long id) {
        log.info("Ejecutando getNotificacionById en NotificacionService");
        return notificacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notificación no encontrada con id " + id));
    }

    public List<Notificacion> getNotificacionesBySocioId(Long socioId) {
        log.info("Ejecutando getNotificacionesBySocioId en NotificacionService");
        return notificacionRepository.findBySocioId(socioId);
    }

    public Notificacion updateNotificacion(Long id, NotificacionDTO notificacion) {
        log.info("Ejecutando updateNotificacion en NotificacionService");
        Notificacion existing = getNotificacionById(id);
        existing.setSocioId(notificacion.getSocioId());
        existing.setTipo(notificacion.getTipo());
        existing.setEstado(notificacion.getEstado());
        existing.setMensaje(notificacion.getMensaje());
        existing.setFechaEnvio(notificacion.getFechaEnvio());
        return notificacionRepository.save(existing);
    }

    public void deleteNotificacion(Long id) {
        log.warn("Ejecutando deleteNotificacion en NotificacionService");
        Notificacion existing = getNotificacionById(id);
        notificacionRepository.delete(existing);
    }
}
