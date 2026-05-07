package servicio_socios.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "socios")
@Data
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
}
