package servicio_socios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import servicio_socios.model.Socio;
import servicio_socios.service.SocioService;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    @Autowired
    private SocioService socioService;

    @PostMapping
    public Socio crearSocio(@RequestBody Socio socio) {
        return socioService.registrarSocioCompleto(socio);
    }
}