package cl.gimnasio.pagos.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.pagos.dto.PagoDTO;
import cl.gimnasio.pagos.service.PagoService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoController {

    private static final Logger log = LoggerFactory.getLogger(PagoController.class);

    private final PagoService pagoService;

    @PostMapping
    public ResponseEntity<PagoDTO> createPago(@Valid @RequestBody PagoDTO request) {
        log.info("Ejecutando createPago en PagoController");
        return ResponseEntity.ok(PagoDTO.fromModel(pagoService.createPago(request)));
    }

    @GetMapping
    public ResponseEntity<List<PagoDTO>> getAllPagos() {
        log.info("Ejecutando getAllPagos en PagoController");
        return ResponseEntity.ok(pagoService.getAllPagos().stream().map(PagoDTO::fromModel).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoDTO> getPagoById(@PathVariable Long id) {
        log.info("Ejecutando getPagoById en PagoController");
        return ResponseEntity.ok(PagoDTO.fromModel(pagoService.getPagoById(id)));
    }

    @Hidden
    @GetMapping("/socio/{socioId}")
    public ResponseEntity<List<PagoDTO>> getPagosBySocioId(@PathVariable Long socioId) {
        log.info("Ejecutando getPagosBySocioId en PagoController");
        return ResponseEntity.ok(pagoService.getPagosBySocioId(socioId).stream().map(PagoDTO::fromModel).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagoDTO> updatePago(@PathVariable Long id, @Valid @RequestBody PagoDTO request) {
        log.info("Ejecutando updatePago en PagoController");
        return ResponseEntity.ok(PagoDTO.fromModel(pagoService.updatePago(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePago(@PathVariable Long id) {
        log.warn("Ejecutando deletePago en PagoController");
        pagoService.deletePago(id);
        return ResponseEntity.noContent().build();
    }
}
