package cl.gimnasio.entrenadores.dto;

import cl.gimnasio.entrenadores.entity.Entrenador;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntrenadorDTO {
    private Long id;
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 80, message = "El nombre no puede superar los 80 caracteres")
    private String nombre;
    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 80, message = "El apellido no puede superar los 80 caracteres")
    private String apellido;
    @NotBlank(message = "La especialidad es obligatoria")
    private String especialidad;
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe tener un formato válido")
    private String correo;
    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "\\+?[0-9]{8,15}", message = "El teléfono debe contener entre 8 y 15 dígitos")
    private String telefono;

    public Entrenador toModel() {
        Entrenador entrenador = new Entrenador();
        entrenador.setId(id);
        entrenador.setNombre(nombre);
        entrenador.setApellido(apellido);
        entrenador.setEspecialidad(especialidad);
        entrenador.setCorreo(correo);
        entrenador.setTelefono(telefono);
        return entrenador;
    }

    public static EntrenadorDTO fromModel(Entrenador entrenador) {
        if (entrenador == null) return null;
        return new EntrenadorDTO(entrenador.getId(), entrenador.getNombre(), entrenador.getApellido(), entrenador.getEspecialidad(), entrenador.getCorreo(), entrenador.getTelefono());
    }
}
