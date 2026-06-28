package cl.gimnasio.reservas.dto;

import cl.gimnasio.reservas.entity.Reserva;
import java.time.LocalDateTime;

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
    private Long socioId;
    private Long claseId;
    private LocalDateTime fechaReserva;
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
