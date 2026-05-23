package cl.gimnasio.socios.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import cl.gimnasio.socios.model.Socio;
import cl.gimnasio.socios.repository.SocioRepository;

@Service
public class SocioService {

    @Autowired
    private SocioRepository socioRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Socio registrarSocioCompleto(Socio socio) {
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
        return socioRepository.findAll();
    }

    public Socio obtenerPorId(Long id) {
        return socioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: Socio no encontrado."));
    }

    public Socio actualizarSocio(Long id, Socio socio) {
        Socio actual = obtenerPorId(id);
        actual.setNombre(socio.getNombre());
        actual.setEmail(socio.getEmail());
        return socioRepository.save(actual);
    }

    public void eliminarSocio(Long id) {
        if (!socioRepository.existsById(id)) {
            throw new RuntimeException("Error: Socio no encontrado.");
        }
        socioRepository.deleteById(id);
    }

    public boolean existePorId(Long id) {
        return socioRepository.existsById(id);
    }
}