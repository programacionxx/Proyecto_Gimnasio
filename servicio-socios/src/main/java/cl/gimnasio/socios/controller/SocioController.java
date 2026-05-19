package cl.gimnasio.socios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cl.gimnasio.socios.model.Socio;
import cl.gimnasio.socios.service.SocioService;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    @Autowired
    private SocioService socioService;

    @PostMapping
    public Socio crearSocio(@RequestBody Socio socio) {
        return socioService.registrarSocioCompleto(socio);
    }

    @GetMapping("/{id}")
    public boolean existeSocio(@PathVariable Long id) {
        return socioService.existePorId(id);
    }
}