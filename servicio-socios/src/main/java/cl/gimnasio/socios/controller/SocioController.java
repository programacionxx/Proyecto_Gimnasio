package cl.gimnasio.socios.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.socios.dto.SocioDTO;
import cl.gimnasio.socios.service.SocioService;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    private static final Logger log = LoggerFactory.getLogger(SocioController.class);

    @Autowired
    private SocioService socioService;

    @PostMapping
    public SocioDTO crearSocio(@Valid @RequestBody SocioDTO socio) {
        log.info("Ejecutando crearSocio en SocioController");
        return SocioDTO.fromModel(socioService.registrarSocioCompleto(socio));
    }

    @GetMapping
    public List<SocioDTO> listarSocios() {
        log.info("Ejecutando listarSocios en SocioController");
        return socioService.listarSocios().stream().map(SocioDTO::fromModel).toList();
    }

    @GetMapping("/{id}")
    public SocioDTO obtenerSocio(@PathVariable Long id) {
        log.info("Ejecutando obtenerSocio en SocioController");
        return SocioDTO.fromModel(socioService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public SocioDTO actualizarSocio(@PathVariable Long id, @Valid @RequestBody SocioDTO socio) {
        log.info("Ejecutando actualizarSocio en SocioController");
        return SocioDTO.fromModel(socioService.actualizarSocio(id, socio));
    }

    @DeleteMapping("/{id}")
    public void eliminarSocio(@PathVariable Long id) {
        log.warn("Ejecutando eliminarSocio en SocioController");
        socioService.eliminarSocio(id);
    }
}
