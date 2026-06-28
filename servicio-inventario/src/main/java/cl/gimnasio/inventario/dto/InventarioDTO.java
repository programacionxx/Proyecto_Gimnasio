package cl.gimnasio.inventario.dto;

import cl.gimnasio.inventario.entity.Inventario;
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
    private String producto;
    private Integer cantidad;
    private String ubicacion;
    private String estado;
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
