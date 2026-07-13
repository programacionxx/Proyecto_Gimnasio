package cl.gimnasio.pagos.service;

import cl.gimnasio.pagos.dto.PagoDTO;
import cl.gimnasio.pagos.entity.Pago;
import cl.gimnasio.pagos.exception.ResourceNotFoundException;
import cl.gimnasio.pagos.repository.PagoRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagoService {

    private static final Logger log = LoggerFactory.getLogger(PagoService.class);

    private final PagoRepository pagoRepository;

    public Pago createPago(PagoDTO request) {
        log.info("Ejecutando createPago en PagoService");
        return pagoRepository.save(request.toModel());
    }

    public List<Pago> getAllPagos() {
        log.info("Ejecutando getAllPagos en PagoService");
        return pagoRepository.findAll();
    }

    public Pago getPagoById(Long id) {
        log.info("Ejecutando getPagoById en PagoService");
        return pagoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pago no encontrado con id " + id));
    }

    public List<Pago> getPagosBySocioId(Long socioId) {
        log.info("Ejecutando getPagosBySocioId en PagoService");
        return pagoRepository.findBySocioId(socioId);
    }

    public Pago updatePago(Long id, PagoDTO request) {
        log.info("Ejecutando updatePago en PagoService");
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
        log.warn("Ejecutando deletePago en PagoService");
        Pago pago = getPagoById(id);
        pagoRepository.delete(pago);
    }
}
