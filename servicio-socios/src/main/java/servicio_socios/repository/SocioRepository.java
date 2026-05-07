package servicio_socios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import servicio_socios.model.Socio;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Long> {
}
