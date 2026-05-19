package cl.gimnasio.socios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import cl.gimnasio.socios.model.Socio;
import cl.gimnasio.socios.repository.SocioRepository;

import java.util.Map;

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

    public boolean existePorId(Long id) {
        return socioRepository.existsById(id);
    }
}