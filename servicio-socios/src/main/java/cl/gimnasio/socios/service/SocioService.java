package cl.gimnasio.socios.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import cl.gimnasio.socios.dto.SocioDTO;
import cl.gimnasio.socios.entity.Socio;
import cl.gimnasio.socios.exception.ResourceNotFoundException;
import cl.gimnasio.socios.repository.SocioRepository;

@Service
public class SocioService {

    private static final Logger log = LoggerFactory.getLogger(SocioService.class);

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Socio registrarSocioCompleto(SocioDTO socioDTO) {
        log.info("Ejecutando registrarSocioCompleto en SocioService");
        Socio socio = socioDTO.toModel();
        Socio nuevoSocio = socioRepository.save(socio);

        webClientBuilder.build()
                .post()
                .uri("http://servicio-autenticacion:8081/api/auth/registrar")
                .bodyValue(Map.of(
                    "username", nuevoSocio.getEmail(),
                    "password", "Socio123*",
                    "rol", "SOCIO"
                ))
                .retrieve()
                .bodyToMono(Object.class)
                .block();

        return nuevoSocio;
    }

    public List<Socio> listarSocios() {
        log.info("Ejecutando listarSocios en SocioService");
        return socioRepository.findAll();
    }

    public Socio obtenerPorId(Long id) {
        log.info("Ejecutando obtenerPorId en SocioService");
        return socioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Error: Socio no encontrado."));
    }

    public Socio actualizarSocio(Long id, SocioDTO socio) {
        log.info("Ejecutando actualizarSocio en SocioService");
        Socio actual = obtenerPorId(id);
        actual.setNombre(socio.getNombre());
        actual.setEmail(socio.getEmail());
        actual.setTelefono(socio.getTelefono());
        actual.setEstado(socio.getEstado());
        return socioRepository.save(actual);
    }

    public void eliminarSocio(Long id) {
        log.warn("Ejecutando eliminarSocio en SocioService");
        if (!socioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Error: Socio no encontrado.");
        }
        socioRepository.deleteById(id);
    }

    public boolean existePorId(Long id) {
        log.info("Ejecutando existePorId en SocioService");
        return socioRepository.existsById(id);
    }
}
