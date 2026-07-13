package cl.gimnasio.entrenadores.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import cl.gimnasio.entrenadores.dto.EntrenadorDTO;
import cl.gimnasio.entrenadores.entity.Entrenador;
import cl.gimnasio.entrenadores.exception.ResourceNotFoundException;
import cl.gimnasio.entrenadores.repository.EntrenadorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EntrenadorService {

    private static final Logger log = LoggerFactory.getLogger(EntrenadorService.class);

    private final EntrenadorRepository entrenadorRepository;

    public Entrenador createEntrenador(EntrenadorDTO request) {
        log.info("Ejecutando createEntrenador en EntrenadorService");
        return entrenadorRepository.save(request.toModel());
    }

    public List<Entrenador> getAllEntrenadores() {
        log.info("Ejecutando getAllEntrenadores en EntrenadorService");
        return entrenadorRepository.findAll();
    }

    public Entrenador getEntrenadorById(Long id) {
        log.info("Ejecutando getEntrenadorById en EntrenadorService");
        return entrenadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entrenador no encontrado con id " + id));
    }

    public Entrenador updateEntrenador(Long id, EntrenadorDTO request) {
        log.info("Ejecutando updateEntrenador en EntrenadorService");
        Entrenador entrenador = getEntrenadorById(id);
        entrenador.setNombre(request.getNombre());
        entrenador.setApellido(request.getApellido());
        entrenador.setEspecialidad(request.getEspecialidad());
        entrenador.setCorreo(request.getCorreo());
        entrenador.setTelefono(request.getTelefono());
        return entrenadorRepository.save(entrenador);
    }

    public void deleteEntrenador(Long id) {
        log.warn("Ejecutando deleteEntrenador en EntrenadorService");
        Entrenador entrenador = getEntrenadorById(id);
        entrenadorRepository.delete(entrenador);
    }
}
