

package servicio_membresias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import servicio_membresias.model.Membresia;
import servicio_membresias.service.MembresiaService;

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