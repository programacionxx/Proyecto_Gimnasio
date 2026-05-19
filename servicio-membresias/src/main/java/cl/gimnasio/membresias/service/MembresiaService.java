package cl.gimnasio.membresias.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import cl.gimnasio.membresias.model.Membresia;
import cl.gimnasio.membresias.repository.MembresiaRepository;

@Service
public class MembresiaService {

    @Autowired
    private MembresiaRepository membresiaRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Membresia contratarPlan(Membresia membresia) {
        Boolean existeSocio = webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/api/socios/" + membresia.getSocioId())
                .retrieve()
                .bodyToMono(Boolean.class) 
                .block();

        if (existeSocio != null && existeSocio) {
            membresia.setFechaInicio(LocalDate.now());
            membresia.setFechaFin(LocalDate.now().plusDays(30));
            membresia.setEstado("ACTIVA");
            return membresiaRepository.save(membresia);
        } else {
            throw new RuntimeException("Error: El socio no existe. No se puede crear membresía.");
        }
    }
}