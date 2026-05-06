package cl.gimnasio.membresias.demo.membresias.repository;

import cl.gimnasio.membresias.demo.membresias.model.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface MembresiaRepository extends JpaRepository<Membresia, Long>{

}
