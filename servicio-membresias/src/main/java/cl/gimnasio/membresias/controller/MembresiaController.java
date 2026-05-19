

package cl.gimnasio.membresias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.membresias.model.Membresia;
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
}