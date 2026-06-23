package cl.gimnasio.notificaciones.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.gimnasio.notificaciones.entity.Notificacion;
import cl.gimnasio.notificaciones.exception.ResourceNotFoundException;
import cl.gimnasio.notificaciones.repository.NotificacionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;

    public Notificacion createNotificacion(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public List<Notificacion> getAllNotificaciones() {
        return notificacionRepository.findAll();
    }

    public Notificacion getNotificacionById(Long id) {
        return notificacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notificación no encontrada con id " + id));
    }

    public List<Notificacion> getNotificacionesBySocioId(Long socioId) {
        return notificacionRepository.findBySocioId(socioId);
    }

    public Notificacion updateNotificacion(Long id, Notificacion notificacion) {
        Notificacion existing = getNotificacionById(id);
        existing.setSocioId(notificacion.getSocioId());
        existing.setTipo(notificacion.getTipo());
        existing.setEstado(notificacion.getEstado());
        existing.setMensaje(notificacion.getMensaje());
        existing.setFechaEnvio(notificacion.getFechaEnvio());
        return notificacionRepository.save(existing);
    }

    public void deleteNotificacion(Long id) {
        Notificacion existing = getNotificacionById(id);
        notificacionRepository.delete(existing);
    }
}
