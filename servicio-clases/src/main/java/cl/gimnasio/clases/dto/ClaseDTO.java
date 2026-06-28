package cl.gimnasio.clases.dto;

import cl.gimnasio.clases.entity.Clase;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClaseDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDateTime horario;
    private Integer capacidadMaxima;
    private Integer duracion;
    private Long entrenadorId;

    public Clase toModel() {
        Clase clase = new Clase();
        clase.setId(id);
        clase.setNombre(nombre);
        clase.setDescripcion(descripcion);
        clase.setHorario(horario);
        clase.setCapacidadMaxima(capacidadMaxima);
        clase.setDuracion(duracion);
        clase.setEntrenadorId(entrenadorId);
        return clase;
    }

    public static ClaseDTO fromModel(Clase clase) {
        if (clase == null) return null;
        return new ClaseDTO(clase.getId(), clase.getNombre(), clase.getDescripcion(), clase.getHorario(), clase.getCapacidadMaxima(), clase.getDuracion(), clase.getEntrenadorId());
    }
}
