package cl.gimnasio.membresias.repository;

import cl.gimnasio.membresias.model.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Long>{

}
