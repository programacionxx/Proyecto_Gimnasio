package cl.gimnasio.membresias.dto;

import cl.gimnasio.membresias.entity.Membresia;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MembresiaDTO {
    private Long id;
    private Long socioId;
    private String tipoPlan;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double precio;
    private String estado;

    public Membresia toModel() {
        Membresia membresia = new Membresia();
        membresia.setId(id);
        membresia.setSocioId(socioId);
        membresia.setTipoPlan(tipoPlan);
        membresia.setFechaInicio(fechaInicio);
        membresia.setFechaFin(fechaFin);
        membresia.setPrecio(precio);
        membresia.setEstado(estado);
        return membresia;
    }

    public static MembresiaDTO fromModel(Membresia membresia) {
        if (membresia == null) return null;
        return new MembresiaDTO(membresia.getId(), membresia.getSocioId(), membresia.getTipoPlan(), membresia.getFechaInicio(), membresia.getFechaFin(), membresia.getPrecio(), membresia.getEstado());
    }
}
