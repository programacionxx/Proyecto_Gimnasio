package cl.gimnasio.autenticacion.demo.autenticacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cl.gimnasio.autenticacion.demo.autenticacion.service.AuthService;
import cl.gimnasio.autenticacion.demo.autenticacion.model.Usuario;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/registrar")
    public Usuario registrar(@RequestBody Usuario usuario) {
        return authService.registrar(usuario);
    }

}
