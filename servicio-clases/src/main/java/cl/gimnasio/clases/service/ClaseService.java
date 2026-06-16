package cl.gimnasio.clases.service;

import cl.gimnasio.clases.entity.Clase;
import cl.gimnasio.clases.exception.ResourceNotFoundException;
import cl.gimnasio.clases.model.ClaseRequest;
import cl.gimnasio.clases.repository.ClaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClaseService {

    private final ClaseRepository claseRepository;

    public Clase createClase(ClaseRequest request) {
        Clase clase = Clase.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .horario(request.getHorario())
                .capacidadMaxima(request.getCapacidadMaxima())
                .duracion(request.getDuracion())
                .entrenadorId(request.getEntrenadorId())
                .build();
        return claseRepository.save(clase);
    }

    public List<Clase> getAllClases() {
        return claseRepository.findAll();
    }

    public Clase getClaseById(Long id) {
        return claseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clase no encontrada con id " + id));
    }

    public Clase updateClase(Long id, ClaseRequest request) {
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
        Clase clase = getClaseById(id);
        claseRepository.delete(clase);
    }
}
