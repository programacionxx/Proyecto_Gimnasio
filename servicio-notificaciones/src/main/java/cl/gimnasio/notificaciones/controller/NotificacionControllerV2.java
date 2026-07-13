package cl.gimnasio.notificaciones.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.notificaciones.assemblers.NotificacionModelAssembler;
import cl.gimnasio.notificaciones.dto.NotificacionDTO;
import cl.gimnasio.notificaciones.service.NotificacionService;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notificaciones/v2")
@RequiredArgsConstructor
public class NotificacionControllerV2 {

    private static final Logger log = LoggerFactory.getLogger(NotificacionControllerV2.class);

    private final NotificacionService notificacionService;
    private final NotificacionModelAssembler assembler;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<NotificacionDTO>>> getAllNotificaciones() {
        log.info("Ejecutando getAllNotificaciones en NotificacionControllerV2");
        List<EntityModel<NotificacionDTO>> notificaciones = notificacionService.getAllNotificaciones().stream()
                .map(NotificacionDTO::fromModel)
                .map(assembler::toModel)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(notificaciones, linkTo(methodOn(NotificacionControllerV2.class).getAllNotificaciones()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<NotificacionDTO>> getNotificacionById(@PathVariable Long id) {
        log.info("Ejecutando getNotificacionById en NotificacionControllerV2");
        NotificacionDTO notificacion = NotificacionDTO.fromModel(notificacionService.getNotificacionById(id));
        return ResponseEntity.ok(assembler.toModel(notificacion));
    }

    @Hidden
    @GetMapping("/socio/{socioId}")
    public ResponseEntity<CollectionModel<EntityModel<NotificacionDTO>>> getNotificacionesBySocioId(@PathVariable Long socioId) {
        log.info("Ejecutando getNotificacionesBySocioId en NotificacionControllerV2");
        List<EntityModel<NotificacionDTO>> notificaciones = notificacionService.getNotificacionesBySocioId(socioId).stream()
                .map(NotificacionDTO::fromModel)
                .map(assembler::toModel)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(notificaciones, linkTo(methodOn(NotificacionControllerV2.class).getNotificacionesBySocioId(socioId)).withSelfRel()));
    }



}
