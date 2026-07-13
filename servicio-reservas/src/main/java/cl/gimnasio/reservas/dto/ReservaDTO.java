package cl.gimnasio.reservas.dto;

import cl.gimnasio.reservas.entity.Reserva;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservaDTO {
    private Long id;
    @NotNull(message = "El socio es obligatorio")
    @Positive(message = "El ID del socio debe ser mayor que cero")
    private Long socioId;
    @NotNull(message = "La clase es obligatoria")
    @Positive(message = "El ID de la clase debe ser mayor que cero")
    private Long claseId;
    @NotNull(message = "La fecha de reserva es obligatoria")
    private LocalDateTime fechaReserva;
    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    public Reserva toModel() {
        Reserva reserva = new Reserva();
        reserva.setId(id);
        reserva.setSocioId(socioId);
        reserva.setClaseId(claseId);
        reserva.setFechaReserva(fechaReserva);
        reserva.setEstado(estado);
        return reserva;
    }

    public static ReservaDTO fromModel(Reserva reserva) {
        if (reserva == null) return null;
        return new ReservaDTO(reserva.getId(), reserva.getSocioId(), reserva.getClaseId(), reserva.getFechaReserva(), reserva.getEstado());
    }
}
