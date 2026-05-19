package cl.gimnasio.socios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cl.gimnasio.socios.model.Socio;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {
}
