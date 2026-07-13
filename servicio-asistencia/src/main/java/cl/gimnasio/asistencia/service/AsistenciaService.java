package cl.gimnasio.asistencia.service;

import cl.gimnasio.asistencia.dto.AsistenciaDTO;
import cl.gimnasio.asistencia.entity.Asistencia;
import cl.gimnasio.asistencia.exception.ResourceNotFoundException;
import cl.gimnasio.asistencia.repository.AsistenciaRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsistenciaService {

    private static final Logger log = LoggerFactory.getLogger(AsistenciaService.class);

    private final AsistenciaRepository asistenciaRepository;

    public Asistencia createAsistencia(AsistenciaDTO request) {
        log.info("Ejecutando createAsistencia en AsistenciaService");
        return asistenciaRepository.save(request.toModel());
    }

    public List<Asistencia> getAllAsistencias() {
        log.info("Ejecutando getAllAsistencias en AsistenciaService");
        return asistenciaRepository.findAll();
    }

    public Asistencia getAsistenciaById(Long id) {
        log.info("Ejecutando getAsistenciaById en AsistenciaService");
        return asistenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asistencia no encontrada con id " + id));
    }

    public Asistencia updateAsistencia(Long id, AsistenciaDTO request) {
        log.info("Ejecutando updateAsistencia en AsistenciaService");
        Asistencia a = getAsistenciaById(id);
        a.setSocioId(request.getSocioId());
        a.setFecha(request.getFecha());
        a.setPresente(request.getPresente());
        return asistenciaRepository.save(a);
    }

    public void deleteAsistencia(Long id) {
        log.warn("Ejecutando deleteAsistencia en AsistenciaService");
        Asistencia a = getAsistenciaById(id);
        asistenciaRepository.delete(a);
    }
}
