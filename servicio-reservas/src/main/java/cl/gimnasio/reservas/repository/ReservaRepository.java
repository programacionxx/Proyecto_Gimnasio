package cl.gimnasio.reservas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.gimnasio.reservas.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
