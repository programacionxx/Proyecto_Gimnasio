package cl.gimnasio.reservas.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import cl.gimnasio.reservas.dto.ReservaDTO;
import cl.gimnasio.reservas.entity.Reserva;
import cl.gimnasio.reservas.repository.ReservaRepository;

@Service
public class ReservaService {

    private static final Logger log = LoggerFactory.getLogger(ReservaService.class);

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> findAll() {
        log.info("Ejecutando findAll en ReservaService");
        return reservaRepository.findAll();
    }

    public Optional<Reserva> findById(Long id) {
        log.info("Ejecutando findById en ReservaService");
        return reservaRepository.findById(id);
    }

    public Reserva save(ReservaDTO reserva) {
        log.info("Ejecutando save en ReservaService");
        return reservaRepository.save(reserva.toModel());
    }

    public void deleteById(Long id) {
        log.warn("Ejecutando deleteById en ReservaService");
        reservaRepository.deleteById(id);
    }
}
