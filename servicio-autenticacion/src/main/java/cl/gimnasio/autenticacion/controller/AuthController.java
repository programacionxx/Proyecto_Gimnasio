package cl.gimnasio.autenticacion.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.autenticacion.dto.UsuarioDTO;
import cl.gimnasio.autenticacion.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    @PostMapping("/registrar")
    public UsuarioDTO registrar(@Valid @RequestBody UsuarioDTO usuario) {
        log.info("Ejecutando registrar en AuthController");
        return UsuarioDTO.fromModel(authService.registrar(usuario));
    }

    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {
        log.info("Ejecutando listarUsuarios en AuthController");
        return authService.listarUsuarios().stream().map(UsuarioDTO::fromModel).toList();
    }

    @GetMapping("/{id}")
    public UsuarioDTO obtenerUsuario(@PathVariable Long id) {
        log.info("Ejecutando obtenerUsuario en AuthController");
        return UsuarioDTO.fromModel(authService.obtenerPorId(id));
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        log.warn("Ejecutando eliminarUsuario en AuthController");
        authService.eliminarUsuario(id);
    }
}
