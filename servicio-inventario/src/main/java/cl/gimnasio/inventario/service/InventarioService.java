package cl.gimnasio.inventario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.gimnasio.inventario.dto.InventarioDTO;
import cl.gimnasio.inventario.entity.Inventario;
import cl.gimnasio.inventario.exception.ResourceNotFoundException;
import cl.gimnasio.inventario.repository.InventarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventarioService {

    private final InventarioRepository inventarioRepository;

    public Inventario createInventario(InventarioDTO inventario) {
        return inventarioRepository.save(inventario.toModel());
    }

    public List<Inventario> getAllInventario() {
        return inventarioRepository.findAll();
    }

    public Inventario getInventarioById(Long id) {
        return inventarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inventario no encontrado con id " + id));
    }

    public List<Inventario> findByProducto(String producto) {
        return inventarioRepository.findByProductoContaining(producto);
    }

    public Inventario updateInventario(Long id, InventarioDTO inventario) {
        Inventario existing = getInventarioById(id);
        existing.setProducto(inventario.getProducto());
        existing.setCantidad(inventario.getCantidad());
        existing.setUbicacion(inventario.getUbicacion());
        existing.setEstado(inventario.getEstado());
        existing.setDescripcion(inventario.getDescripcion());
        return inventarioRepository.save(existing);
    }

    public void deleteInventario(Long id) {
        Inventario existing = getInventarioById(id);
        inventarioRepository.delete(existing);
    }
}
