package cl.gimnasio.pagos.dto;

import cl.gimnasio.pagos.entity.Pago;
import java.time.LocalDateTime;

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
    private Long socioId;
    private Double monto;
    private LocalDateTime fechaPago;
    private String metodoPago;
    private String estadoPago;
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
