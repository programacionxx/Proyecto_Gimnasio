package cl.gimnasio.socios.dto;

import cl.gimnasio.socios.entity.Socio;
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
public class SocioDTO {
    private Long id;
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 120, message = "El nombre no puede superar los 120 caracteres")
    private String nombre;
    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe tener un formato válido")
    private String email;
    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "\\+?[0-9]{8,15}", message = "El teléfono debe contener entre 8 y 15 dígitos")
    private String telefono;
    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    public Socio toModel() {
        Socio socio = new Socio();
        socio.setId(id);
        socio.setNombre(nombre);
        socio.setEmail(email);
        socio.setTelefono(telefono);
        socio.setEstado(estado);
        return socio;
    }

    public static SocioDTO fromModel(Socio socio) {
        if (socio == null) return null;
        return new SocioDTO(socio.getId(), socio.getNombre(), socio.getEmail(), socio.getTelefono(), socio.getEstado());
    }
}
