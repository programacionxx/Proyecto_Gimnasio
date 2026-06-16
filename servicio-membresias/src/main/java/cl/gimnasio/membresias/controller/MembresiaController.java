package cl.gimnasio.membresias.controller;

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

import cl.gimnasio.membresias.entity.Membresia;
import cl.gimnasio.membresias.service.MembresiaService;

@RestController
@RequestMapping("/api/membresias")
public class MembresiaController {

    @Autowired
    private MembresiaService membresiaService;

    @PostMapping
    public Membresia crearMembresia(@RequestBody Membresia membresia) {
        return membresiaService.contratarPlan(membresia);
    }

    @GetMapping
    public List<Membresia> listarMembresias() {
        return membresiaService.listarMembresias();
    }

    @GetMapping("/{id}")
    public Membresia obtenerMembresia(@PathVariable Long id) {
        return membresiaService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Membresia actualizarMembresia(@PathVariable Long id, @RequestBody Membresia membresia) {
        return membresiaService.actualizarMembresia(id, membresia);
    }

    @DeleteMapping("/{id}")
    public void eliminarMembresia(@PathVariable Long id) {
        membresiaService.eliminarMembresia(id);
    }
}