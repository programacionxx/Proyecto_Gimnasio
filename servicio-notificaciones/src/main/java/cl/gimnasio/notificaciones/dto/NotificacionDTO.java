package cl.gimnasio.notificaciones.dto;

import cl.gimnasio.notificaciones.entity.Notificacion;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificacionDTO {
    private Long id;
    private Long socioId;
    private String tipo;
    private String estado;
    private String mensaje;
    private LocalDateTime fechaEnvio;

    public Notificacion toModel() {
        Notificacion notificacion = new Notificacion();
        notificacion.setId(id);
        notificacion.setSocioId(socioId);
        notificacion.setTipo(tipo);
        notificacion.setEstado(estado);
        notificacion.setMensaje(mensaje);
        notificacion.setFechaEnvio(fechaEnvio);
        return notificacion;
    }

    public static NotificacionDTO fromModel(Notificacion notificacion) {
        if (notificacion == null) return null;
        return new NotificacionDTO(notificacion.getId(), notificacion.getSocioId(), notificacion.getTipo(), notificacion.getEstado(), notificacion.getMensaje(), notificacion.getFechaEnvio());
    }
}
