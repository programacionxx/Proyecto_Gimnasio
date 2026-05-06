import com.gimnasio.socios.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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