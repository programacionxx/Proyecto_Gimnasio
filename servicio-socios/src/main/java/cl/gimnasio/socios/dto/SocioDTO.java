package cl.gimnasio.socios.dto;

import cl.gimnasio.socios.entity.Socio;
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
    private String nombre;
    private String email;
    private String telefono;
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
