package cl.gimnasio.pagos.dto;

import cl.gimnasio.pagos.entity.Pago;
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
public class PagoDTO {
    private Long id;
    @NotNull(message = "El socio es obligatorio")
    @Positive(message = "El ID del socio debe ser mayor que cero")
    private Long socioId;
    @NotNull(message = "El monto es obligatorio")
    @Positive(message = "El monto debe ser mayor que cero")
    private Double monto;
    @NotNull(message = "La fecha de pago es obligatoria")
    private LocalDateTime fechaPago;
    @NotBlank(message = "El método de pago es obligatorio")
    private String metodoPago;
    @NotBlank(message = "El estado del pago es obligatorio")
    private String estadoPago;
    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    private String descripcion;

    public Pago toModel() {
        Pago pago = new Pago();
        pago.setId(id);
        pago.setSocioId(socioId);
        pago.setMonto(monto);
        pago.setFechaPago(fechaPago);
        pago.setMetodoPago(metodoPago);
        pago.setEstadoPago(estadoPago);
        pago.setDescripcion(descripcion);
        return pago;
    }

    public static PagoDTO fromModel(Pago pago) {
        if (pago == null) return null;
        return new PagoDTO(pago.getId(), pago.getSocioId(), pago.getMonto(), pago.getFechaPago(), pago.getMetodoPago(), pago.getEstadoPago(), pago.getDescripcion());
    }
}
