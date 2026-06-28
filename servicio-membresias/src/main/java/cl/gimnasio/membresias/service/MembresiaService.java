package cl.gimnasio.membresias.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import cl.gimnasio.membresias.dto.MembresiaDTO;
import cl.gimnasio.membresias.entity.Membresia;
import cl.gimnasio.membresias.exception.ResourceNotFoundException;
import cl.gimnasio.membresias.repository.MembresiaRepository;

@Service
public class MembresiaService {

    @Autowired
    private MembresiaRepository membresiaRepository;

    public Membresia contratarPlan(MembresiaDTO membresiaDTO) {
        Membresia membresia = membresiaDTO.toModel();
        Map<String, Object> respuesta;

        try {
            respuesta = WebClient.create()
                .get()
                .uri("http://servicio-socios:8082/api/socios/" + membresia.getSocioId())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {})
                .block();
        } catch (WebClientResponseException e) {
            throw new RuntimeException("Error: El socio no existe. No se puede crear membresía.");
        }

        if (respuesta != null && respuesta.get("id") != null) {
            membresia.setFechaInicio(LocalDate.now());
            membresia.setFechaFin(LocalDate.now().plusDays(30));
            membresia.setEstado("ACTIVA");
            return membresiaRepository.save(membresia);
        }

        throw new RuntimeException("Error: El socio no existe. No se puede crear membresía.");
    }

    public List<Membresia> listarMembresias() {
        return membresiaRepository.findAll();
    }

    public Membresia obtenerPorId(Long id) {
        return membresiaRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Error: Membresía no encontrada."));
    }

    public Membresia actualizarMembresia(Long id, MembresiaDTO membresia) {
        Membresia actual = obtenerPorId(id);
        actual.setSocioId(membresia.getSocioId());
        actual.setTipoPlan(membresia.getTipoPlan());
        actual.setPrecio(membresia.getPrecio());
        actual.setFechaInicio(membresia.getFechaInicio());
        actual.setFechaFin(membresia.getFechaFin());
        actual.setEstado(membresia.getEstado());
        return membresiaRepository.save(actual);
    }

    public void eliminarMembresia(Long id) {
        if (!membresiaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Error: Membresía no encontrada.");
        }
        membresiaRepository.deleteById(id);
    }
}
