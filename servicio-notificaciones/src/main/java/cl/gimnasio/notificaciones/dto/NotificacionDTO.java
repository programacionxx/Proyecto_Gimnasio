package cl.gimnasio.notificaciones.dto;

import cl.gimnasio.notificaciones.entity.Notificacion;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

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
    @NotNull(message = "El socio es obligatorio")
    @Positive(message = "El ID del socio debe ser mayor que cero")
    private Long socioId;
    @NotBlank(message = "El tipo es obligatorio")
    private String tipo;
    @NotBlank(message = "El estado es obligatorio")
    private String estado;
    @NotBlank(message = "El mensaje es obligatorio")
    @Size(max = 500, message = "El mensaje no puede superar los 500 caracteres")
    private String mensaje;
    @NotNull(message = "La fecha de envío es obligatoria")
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
