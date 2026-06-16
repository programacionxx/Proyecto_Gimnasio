package cl.gimnasio.membresias.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.gimnasio.membresias.entity.Membresia;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Long>{

}
