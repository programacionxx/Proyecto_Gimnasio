package cl.gimnasio.membresias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.membresias.dto.MembresiaDTO;
import cl.gimnasio.membresias.service.MembresiaService;

@RestController
@RequestMapping("/api/membresias")
public class MembresiaController {

    @Autowired
    private MembresiaService membresiaService;

    @PostMapping
    public MembresiaDTO crearMembresia(@RequestBody MembresiaDTO membresia) {
        return MembresiaDTO.fromModel(membresiaService.contratarPlan(membresia));
    }

    @GetMapping
    public List<MembresiaDTO> listarMembresias() {
        return membresiaService.listarMembresias().stream().map(MembresiaDTO::fromModel).toList();
    }

    @GetMapping("/{id}")
    public MembresiaDTO obtenerMembresia(@PathVariable Long id) {
        return MembresiaDTO.fromModel(membresiaService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public MembresiaDTO actualizarMembresia(@PathVariable Long id, @RequestBody MembresiaDTO membresia) {
        return MembresiaDTO.fromModel(membresiaService.actualizarMembresia(id, membresia));
    }

    @DeleteMapping("/{id}")
    public void eliminarMembresia(@PathVariable Long id) {
        membresiaService.eliminarMembresia(id);
    }
}
