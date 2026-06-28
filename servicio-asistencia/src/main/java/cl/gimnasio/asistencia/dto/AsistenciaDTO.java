package cl.gimnasio.asistencia.dto;

import cl.gimnasio.asistencia.entity.Asistencia;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AsistenciaDTO {
    private Long id;
    private Long socioId;
    private LocalDateTime fecha;
    private Boolean presente;

    public Asistencia toModel() {
        Asistencia asistencia = new Asistencia();
        asistencia.setId(id);
        asistencia.setSocioId(socioId);
        asistencia.setFecha(fecha);
        asistencia.setPresente(presente);
        return asistencia;
    }

    public static AsistenciaDTO fromModel(Asistencia asistencia) {
        if (asistencia == null) return null;
        return new AsistenciaDTO(asistencia.getId(), asistencia.getSocioId(), asistencia.getFecha(), asistencia.getPresente());
    }
}
