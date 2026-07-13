package cl.gimnasio.autenticacion.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cl.gimnasio.autenticacion.dto.UsuarioDTO;
import cl.gimnasio.autenticacion.entity.Usuario;
import cl.gimnasio.autenticacion.exception.ResourceNotFoundException;
import cl.gimnasio.autenticacion.repository.UsuarioRepository;

@Service
public class AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario registrar(UsuarioDTO usuarioDTO) {
        log.info("Ejecutando registrar en AuthService");
        Usuario usuario = usuarioDTO.toModel();
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        log.info("Ejecutando listarUsuarios en AuthService");
        return usuarioRepository.findAll();
    }

    public Usuario obtenerPorId(Long id) {
        log.info("Ejecutando obtenerPorId en AuthService");
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Error: Usuario no encontrado."));
    }

    public void eliminarUsuario(Long id) {
        log.warn("Ejecutando eliminarUsuario en AuthService");
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Error: Usuario no encontrado.");
        }
        usuarioRepository.deleteById(id);
    }
}
