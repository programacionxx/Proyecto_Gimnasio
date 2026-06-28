package cl.gimnasio.notificaciones.controller;

import java.util.List;

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

    private final NotificacionService notificacionService;
    private final NotificacionModelAssembler assembler;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<NotificacionDTO>>> getAllNotificaciones() {
        List<EntityModel<NotificacionDTO>> notificaciones = notificacionService.getAllNotificaciones().stream()
                .map(NotificacionDTO::fromModel)
                .map(assembler::toModel)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(notificaciones, linkTo(methodOn(NotificacionControllerV2.class).getAllNotificaciones()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<NotificacionDTO>> getNotificacionById(@PathVariable Long id) {
        NotificacionDTO notificacion = NotificacionDTO.fromModel(notificacionService.getNotificacionById(id));
        return ResponseEntity.ok(assembler.toModel(notificacion));
    }

    @Hidden
    @GetMapping("/socio/{socioId}")
    public ResponseEntity<CollectionModel<EntityModel<NotificacionDTO>>> getNotificacionesBySocioId(@PathVariable Long socioId) {
        List<EntityModel<NotificacionDTO>> notificaciones = notificacionService.getNotificacionesBySocioId(socioId).stream()
                .map(NotificacionDTO::fromModel)
                .map(assembler::toModel)
                .toList();
        return ResponseEntity.ok(CollectionModel.of(notificaciones, linkTo(methodOn(NotificacionControllerV2.class).getNotificacionesBySocioId(socioId)).withSelfRel()));
    }



}
