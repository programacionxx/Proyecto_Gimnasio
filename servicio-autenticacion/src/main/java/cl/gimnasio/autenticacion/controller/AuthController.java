package cl.gimnasio.autenticacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.gimnasio.autenticacion.model.Usuario;
import cl.gimnasio.autenticacion.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/registrar")
    public Usuario registrar(@RequestBody Usuario usuario) {
        return authService.registrar(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return authService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return authService.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        authService.eliminarUsuario(id);
    }
}
