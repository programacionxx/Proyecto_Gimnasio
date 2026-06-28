package cl.gimnasio.notificaciones.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import cl.gimnasio.notificaciones.controller.NotificacionControllerV2;
import cl.gimnasio.notificaciones.dto.NotificacionDTO;

@Component
public class NotificacionModelAssembler implements RepresentationModelAssembler<NotificacionDTO, EntityModel<NotificacionDTO>> {

    @Override
    public EntityModel<NotificacionDTO> toModel(NotificacionDTO dto) {
        return EntityModel.of(dto,
                linkTo(methodOn(NotificacionControllerV2.class).getNotificacionById(dto.getId())).withSelfRel(),
                linkTo(methodOn(NotificacionControllerV2.class).getAllNotificaciones()).withRel("notificaciones"));
    }
}
