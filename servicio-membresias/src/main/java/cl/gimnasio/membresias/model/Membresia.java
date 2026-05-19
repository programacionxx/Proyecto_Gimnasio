package cl.gimnasio.membresias.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "membresias")
@Data
public class Membresia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long socioId; 
    private String tipoPlan; 
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Double precio;
    private String estado; 
}