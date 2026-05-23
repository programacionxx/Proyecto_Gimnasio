package cl.gimnasio.socios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public List<Socio> listarSocios() {
        return socioService.listarSocios();
    }

    @GetMapping("/{id}")
    public Socio obtenerSocio(@PathVariable Long id) {
        return socioService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Socio actualizarSocio(@PathVariable Long id, @RequestBody Socio socio) {
        return socioService.actualizarSocio(id, socio);
    }

    @DeleteMapping("/{id}")
    public void eliminarSocio(@PathVariable Long id) {
        socioService.eliminarSocio(id);
    }
}