

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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