package cl.gimnasio.socios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.socios.dto.SocioDTO;
import cl.gimnasio.socios.service.SocioService;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    @Autowired
    private SocioService socioService;

    @PostMapping
    public SocioDTO crearSocio(@RequestBody SocioDTO socio) {
        return SocioDTO.fromModel(socioService.registrarSocioCompleto(socio));
    }

    @GetMapping
    public List<SocioDTO> listarSocios() {
        return socioService.listarSocios().stream().map(SocioDTO::fromModel).toList();
    }

    @GetMapping("/{id}")
    public SocioDTO obtenerSocio(@PathVariable Long id) {
        return SocioDTO.fromModel(socioService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public SocioDTO actualizarSocio(@PathVariable Long id, @RequestBody SocioDTO socio) {
        return SocioDTO.fromModel(socioService.actualizarSocio(id, socio));
    }

    @DeleteMapping("/{id}")
    public void eliminarSocio(@PathVariable Long id) {
        socioService.eliminarSocio(id);
    }
}
