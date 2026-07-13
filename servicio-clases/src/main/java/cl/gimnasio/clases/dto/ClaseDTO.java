package cl.gimnasio.clases.dto;

import cl.gimnasio.clases.entity.Clase;
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
public class ClaseDTO {
    private Long id;
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    private String nombre;
    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    private String descripcion;
    @NotNull(message = "El horario es obligatorio")
    private LocalDateTime horario;
    @NotNull(message = "La capacidad máxima es obligatoria")
    @Positive(message = "La capacidad máxima debe ser mayor que cero")
    private Integer capacidadMaxima;
    @NotNull(message = "La duración es obligatoria")
    @Positive(message = "La duración debe ser mayor que cero")
    private Integer duracion;
    @NotNull(message = "El entrenador es obligatorio")
    @Positive(message = "El ID del entrenador debe ser mayor que cero")
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
