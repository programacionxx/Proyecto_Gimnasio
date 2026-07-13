package cl.gimnasio.inventario.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import cl.gimnasio.inventario.dto.InventarioDTO;
import cl.gimnasio.inventario.entity.Inventario;
import cl.gimnasio.inventario.exception.ResourceNotFoundException;
import cl.gimnasio.inventario.repository.InventarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventarioService {

    private static final Logger log = LoggerFactory.getLogger(InventarioService.class);

    private final InventarioRepository inventarioRepository;

    public Inventario createInventario(InventarioDTO inventario) {
        log.info("Ejecutando createInventario en InventarioService");
        return inventarioRepository.save(inventario.toModel());
    }

    public List<Inventario> getAllInventario() {
        log.info("Ejecutando getAllInventario en InventarioService");
        return inventarioRepository.findAll();
    }

    public Inventario getInventarioById(Long id) {
        log.info("Ejecutando getInventarioById en InventarioService");
        return inventarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inventario no encontrado con id " + id));
    }

    public List<Inventario> findByProducto(String producto) {
        log.info("Ejecutando findByProducto en InventarioService");
        return inventarioRepository.findByProductoContaining(producto);
    }

    public Inventario updateInventario(Long id, InventarioDTO inventario) {
        log.info("Ejecutando updateInventario en InventarioService");
        Inventario existing = getInventarioById(id);
        existing.setProducto(inventario.getProducto());
        existing.setCantidad(inventario.getCantidad());
        existing.setUbicacion(inventario.getUbicacion());
        existing.setEstado(inventario.getEstado());
        existing.setDescripcion(inventario.getDescripcion());
        return inventarioRepository.save(existing);
    }

    public void deleteInventario(Long id) {
        log.warn("Ejecutando deleteInventario en InventarioService");
        Inventario existing = getInventarioById(id);
        inventarioRepository.delete(existing);
    }
}
