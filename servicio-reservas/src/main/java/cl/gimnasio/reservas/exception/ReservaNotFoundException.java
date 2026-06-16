package cl.gimnasio.reservas.exception;

public class ReservaNotFoundException extends RuntimeException {
    public ReservaNotFoundException(Long id) {
        super("Reserva no encontrada: " + id);
    }
}
