package cl.gimnasio.autenticacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.gimnasio.autenticacion.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
