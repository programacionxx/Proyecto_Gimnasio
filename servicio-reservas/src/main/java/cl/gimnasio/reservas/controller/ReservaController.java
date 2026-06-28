package cl.gimnasio.reservas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.reservas.dto.ReservaDTO;
import cl.gimnasio.reservas.service.ReservaService;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public List<ReservaDTO> getAllReservas() {
        return reservaService.findAll().stream().map(ReservaDTO::fromModel).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReservaDTO createReserva(@RequestBody ReservaDTO reserva) {
        return ReservaDTO.fromModel(reservaService.save(reserva));
    }
}
