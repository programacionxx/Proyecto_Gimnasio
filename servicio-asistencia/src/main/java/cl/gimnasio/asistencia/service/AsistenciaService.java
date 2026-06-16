package cl.gimnasio.asistencia.service;

import cl.gimnasio.asistencia.entity.Asistencia;
import cl.gimnasio.asistencia.exception.ResourceNotFoundException;
import cl.gimnasio.asistencia.repository.AsistenciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsistenciaService {

    private final AsistenciaRepository asistenciaRepository;

    public Asistencia createAsistencia(Asistencia request) {
        Asistencia a = Asistencia.builder()
                .socioId(request.getSocioId())
                .fecha(request.getFecha())
                .presente(request.getPresente())
                .build();
        return asistenciaRepository.save(a);
    }

    public List<Asistencia> getAllAsistencias() {
        return asistenciaRepository.findAll();
    }

    public Asistencia getAsistenciaById(Long id) {
        return asistenciaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Asistencia no encontrada con id " + id));
    }

    public Asistencia updateAsistencia(Long id, Asistencia request) {
        Asistencia a = getAsistenciaById(id);
        a.setSocioId(request.getSocioId());
        a.setFecha(request.getFecha());
        a.setPresente(request.getPresente());
        return asistenciaRepository.save(a);
    }

    public void deleteAsistencia(Long id) {
        Asistencia a = getAsistenciaById(id);
        asistenciaRepository.delete(a);
    }
}
