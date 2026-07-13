package cl.gimnasio.reservas.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.reservas.dto.ReservaDTO;
import cl.gimnasio.reservas.service.ReservaService;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private static final Logger log = LoggerFactory.getLogger(ReservaController.class);

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public List<ReservaDTO> getAllReservas() {
        log.info("Ejecutando getAllReservas en ReservaController");
        return reservaService.findAll().stream().map(ReservaDTO::fromModel).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReservaDTO createReserva(@Valid @RequestBody ReservaDTO reserva) {
        log.info("Ejecutando createReserva en ReservaController");
        return ReservaDTO.fromModel(reservaService.save(reserva));
    }
}
