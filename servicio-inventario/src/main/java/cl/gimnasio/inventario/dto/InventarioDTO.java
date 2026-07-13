package cl.gimnasio.inventario.dto;

import cl.gimnasio.inventario.entity.Inventario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventarioDTO {
    private Long id;
    @NotBlank(message = "El producto es obligatorio")
    private String producto;
    @NotNull(message = "La cantidad es obligatoria")
    @PositiveOrZero(message = "La cantidad no puede ser negativa")
    private Integer cantidad;
    @NotBlank(message = "La ubicación es obligatoria")
    private String ubicacion;
    @NotBlank(message = "El estado es obligatorio")
    private String estado;
    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    private String descripcion;

    public Inventario toModel() {
        Inventario inventario = new Inventario();
        inventario.setId(id);
        inventario.setProducto(producto);
        inventario.setCantidad(cantidad);
        inventario.setUbicacion(ubicacion);
        inventario.setEstado(estado);
        inventario.setDescripcion(descripcion);
        return inventario;
    }

    public static InventarioDTO fromModel(Inventario inventario) {
        if (inventario == null) return null;
        return new InventarioDTO(inventario.getId(), inventario.getProducto(), inventario.getCantidad(), inventario.getUbicacion(), inventario.getEstado(), inventario.getDescripcion());
    }
}
