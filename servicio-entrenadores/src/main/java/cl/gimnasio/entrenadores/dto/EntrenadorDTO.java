package cl.gimnasio.entrenadores.dto;

import cl.gimnasio.entrenadores.entity.Entrenador;
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
    private String nombre;
    private String apellido;
    private String especialidad;
    private String correo;
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
