package cl.gimnasio.pagos.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.pagos.assemblers.PagoModelAssembler;
import cl.gimnasio.pagos.dto.PagoDTO;
import cl.gimnasio.pagos.service.PagoService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pagos/v2")
@RequiredArgsConstructor
public class PagoControllerV2 {

    private static final Logger log = LoggerFactory.getLogger(PagoControllerV2.class);

    private final PagoService pagoService;
    private final PagoModelAssembler assembler;


    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<PagoDTO>>> getAllPagos() {
        log.info("Ejecutando getAllPagos en PagoControllerV2");
        List<EntityModel<PagoDTO>> pagos = pagoService.getAllPagos().stream()
                .map(PagoDTO::fromModel)
                .map(assembler::toModel)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(pagos, linkTo(methodOn(PagoControllerV2.class).getAllPagos()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<PagoDTO>> getPagoById(@PathVariable Long id) {
        log.info("Ejecutando getPagoById en PagoControllerV2");
        PagoDTO pago = PagoDTO.fromModel(pagoService.getPagoById(id));
        return ResponseEntity.ok(assembler.toModel(pago));
    }

    @Hidden
    @GetMapping("/socio/{socioId}")
    public ResponseEntity<CollectionModel<EntityModel<PagoDTO>>> getPagosBySocioId(@PathVariable Long socioId) {
        log.info("Ejecutando getPagosBySocioId en PagoControllerV2");
        List<EntityModel<PagoDTO>> pagos = pagoService.getPagosBySocioId(socioId).stream()
                .map(PagoDTO::fromModel)
                .map(assembler::toModel)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(pagos, linkTo(methodOn(PagoControllerV2.class).getPagosBySocioId(socioId)).withSelfRel()));
    }


}
