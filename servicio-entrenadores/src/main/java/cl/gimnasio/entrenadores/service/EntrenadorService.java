package cl.gimnasio.entrenadores.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.gimnasio.entrenadores.dto.EntrenadorDTO;
import cl.gimnasio.entrenadores.entity.Entrenador;
import cl.gimnasio.entrenadores.exception.ResourceNotFoundException;
import cl.gimnasio.entrenadores.repository.EntrenadorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EntrenadorService {

    private final EntrenadorRepository entrenadorRepository;

    public Entrenador createEntrenador(EntrenadorDTO request) {
        return entrenadorRepository.save(request.toModel());
    }

    public List<Entrenador> getAllEntrenadores() {
        return entrenadorRepository.findAll();
    }

    public Entrenador getEntrenadorById(Long id) {
        return entrenadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entrenador no encontrado con id " + id));
    }

    public Entrenador updateEntrenador(Long id, EntrenadorDTO request) {
        Entrenador entrenador = getEntrenadorById(id);
        entrenador.setNombre(request.getNombre());
        entrenador.setApellido(request.getApellido());
        entrenador.setEspecialidad(request.getEspecialidad());
        entrenador.setCorreo(request.getCorreo());
        entrenador.setTelefono(request.getTelefono());
        return entrenadorRepository.save(entrenador);
    }

    public void deleteEntrenador(Long id) {
        Entrenador entrenador = getEntrenadorById(id);
        entrenadorRepository.delete(entrenador);
    }
}
