package cl.gimnasio.asistencia.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import cl.gimnasio.asistencia.controller.AsistenciaControllerV2;
import cl.gimnasio.asistencia.dto.AsistenciaDTO;

@Component
public class AsistenciaModelAssembler implements RepresentationModelAssembler<AsistenciaDTO, EntityModel<AsistenciaDTO>> {

    @Override
    public EntityModel<AsistenciaDTO> toModel(AsistenciaDTO dto) {
        return EntityModel.of(dto,
                linkTo(methodOn(AsistenciaControllerV2.class).one(dto.getId())).withSelfRel(),
                linkTo(methodOn(AsistenciaControllerV2.class).all()).withRel("asistencias"));
    }
}
