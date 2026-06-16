package cl.gimnasio.pagos.service;

import cl.gimnasio.pagos.entity.Pago;
import cl.gimnasio.pagos.exception.ResourceNotFoundException;
import cl.gimnasio.pagos.model.PagoRequest;
import cl.gimnasio.pagos.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagoService {

    private final PagoRepository pagoRepository;

    public Pago createPago(PagoRequest request) {
        Pago pago = Pago.builder()
                .socioId(request.getSocioId())
                .monto(request.getMonto())
                .fechaPago(request.getFechaPago())
                .metodoPago(request.getMetodoPago())
                .estadoPago(request.getEstadoPago())
                .descripcion(request.getDescripcion())
                .build();
        return pagoRepository.save(pago);
    }

    public List<Pago> getAllPagos() {
        return pagoRepository.findAll();
    }

    public Pago getPagoById(Long id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado con id " + id));
    }

    public List<Pago> getPagosBySocioId(Long socioId) {
        return pagoRepository.findBySocioId(socioId);
    }

    public Pago updatePago(Long id, PagoRequest request) {
        Pago existingPago = getPagoById(id);
        existingPago.setSocioId(request.getSocioId());
        existingPago.setMonto(request.getMonto());
        existingPago.setFechaPago(request.getFechaPago());
        existingPago.setMetodoPago(request.getMetodoPago());
        existingPago.setEstadoPago(request.getEstadoPago());
        existingPago.setDescripcion(request.getDescripcion());
        return pagoRepository.save(existingPago);
    }

    public void deletePago(Long id) {
        Pago pago = getPagoById(id);
        pagoRepository.delete(pago);
    }
}
