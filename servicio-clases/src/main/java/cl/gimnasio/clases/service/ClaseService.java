package cl.gimnasio.clases.service;

import cl.gimnasio.clases.dto.ClaseDTO;
import cl.gimnasio.clases.entity.Clase;
import cl.gimnasio.clases.exception.ResourceNotFoundException;
import cl.gimnasio.clases.repository.ClaseRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClaseService {

    private static final Logger log = LoggerFactory.getLogger(ClaseService.class);

    private final ClaseRepository claseRepository;

    public Clase createClase(ClaseDTO request) {
        log.info("Ejecutando createClase en ClaseService");
        return claseRepository.save(request.toModel());
    }

    public List<Clase> getAllClases() {
        log.info("Ejecutando getAllClases en ClaseService");
        return claseRepository.findAll();
    }

    public Clase getClaseById(Long id) {
        log.info("Ejecutando getClaseById en ClaseService");
        return claseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clase no encontrada con id " + id));
    }

    public Clase updateClase(Long id, ClaseDTO request) {
        log.info("Ejecutando updateClase en ClaseService");
        Clase clase = getClaseById(id);
        clase.setNombre(request.getNombre());
        clase.setDescripcion(request.getDescripcion());
        clase.setHorario(request.getHorario());
        clase.setCapacidadMaxima(request.getCapacidadMaxima());
        clase.setDuracion(request.getDuracion());
        clase.setEntrenadorId(request.getEntrenadorId());
        return claseRepository.save(clase);
    }

    public void deleteClase(Long id) {
        log.warn("Ejecutando deleteClase en ClaseService");
        Clase clase = getClaseById(id);
        claseRepository.delete(clase);
    }
}
