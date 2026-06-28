package cl.gimnasio.autenticacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.autenticacion.dto.UsuarioDTO;
import cl.gimnasio.autenticacion.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/registrar")
    public UsuarioDTO registrar(@RequestBody UsuarioDTO usuario) {
        return UsuarioDTO.fromModel(authService.registrar(usuario));
    }

    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {
        return authService.listarUsuarios().stream().map(UsuarioDTO::fromModel).toList();
    }

    @GetMapping("/{id}")
    public UsuarioDTO obtenerUsuario(@PathVariable Long id) {
        return UsuarioDTO.fromModel(authService.obtenerPorId(id));
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        authService.eliminarUsuario(id);
    }
}
