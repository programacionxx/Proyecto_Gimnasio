package cl.gimnasio.pagos.controller;

import java.util.List;

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

    private final PagoService pagoService;

    @PostMapping
    public ResponseEntity<PagoDTO> createPago(@Valid @RequestBody PagoDTO request) {
        return ResponseEntity.ok(PagoDTO.fromModel(pagoService.createPago(request)));
    }

    @GetMapping
    public ResponseEntity<List<PagoDTO>> getAllPagos() {
        return ResponseEntity.ok(pagoService.getAllPagos().stream().map(PagoDTO::fromModel).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoDTO> getPagoById(@PathVariable Long id) {
        return ResponseEntity.ok(PagoDTO.fromModel(pagoService.getPagoById(id)));
    }

    @Hidden
    @GetMapping("/socio/{socioId}")
    public ResponseEntity<List<PagoDTO>> getPagosBySocioId(@PathVariable Long socioId) {
        return ResponseEntity.ok(pagoService.getPagosBySocioId(socioId).stream().map(PagoDTO::fromModel).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagoDTO> updatePago(@PathVariable Long id, @Valid @RequestBody PagoDTO request) {
        return ResponseEntity.ok(PagoDTO.fromModel(pagoService.updatePago(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePago(@PathVariable Long id) {
        pagoService.deletePago(id);
        return ResponseEntity.noContent().build();
    }
}
