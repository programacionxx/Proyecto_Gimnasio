package cl.gimnasio.membresias.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.membresias.dto.MembresiaDTO;
import cl.gimnasio.membresias.service.MembresiaService;

@RestController
@RequestMapping("/api/membresias")
public class MembresiaController {

    private static final Logger log = LoggerFactory.getLogger(MembresiaController.class);

    @Autowired
    private MembresiaService membresiaService;

    @PostMapping
    public MembresiaDTO crearMembresia(@Valid @RequestBody MembresiaDTO membresia) {
        log.info("Ejecutando crearMembresia en MembresiaController");
        return MembresiaDTO.fromModel(membresiaService.contratarPlan(membresia));
    }

    @GetMapping
    public List<MembresiaDTO> listarMembresias() {
        log.info("Ejecutando listarMembresias en MembresiaController");
        return membresiaService.listarMembresias().stream().map(MembresiaDTO::fromModel).toList();
    }

    @GetMapping("/{id}")
    public MembresiaDTO obtenerMembresia(@PathVariable Long id) {
        log.info("Ejecutando obtenerMembresia en MembresiaController");
        return MembresiaDTO.fromModel(membresiaService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public MembresiaDTO actualizarMembresia(@PathVariable Long id, @Valid @RequestBody MembresiaDTO membresia) {
        log.info("Ejecutando actualizarMembresia en MembresiaController");
        return MembresiaDTO.fromModel(membresiaService.actualizarMembresia(id, membresia));
    }

    @DeleteMapping("/{id}")
    public void eliminarMembresia(@PathVariable Long id) {
        log.warn("Ejecutando eliminarMembresia en MembresiaController");
        membresiaService.eliminarMembresia(id);
    }
}
