package cl.gimnasio.membresias.dto;

import cl.gimnasio.membresias.entity.Membresia;
import java.time.LocalDate;

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
public class MembresiaDTO {
    private Long id;
    @NotNull(message = "El socio es obligatorio")
    @Positive(message = "El ID del socio debe ser mayor que cero")
    private Long socioId;
    @NotBlank(message = "El tipo de plan es obligatorio")
    private String tipoPlan;
    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate fechaInicio;
    @NotNull(message = "La fecha de término es obligatoria")
    private LocalDate fechaFin;
    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor que cero")
    private Double precio;
    @NotBlank(message = "El estado es obligatorio")
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
