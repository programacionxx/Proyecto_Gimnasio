package cl.gimnasio.clases.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.gimnasio.clases.entity.Clase;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Long> {
}
