package cl.gimnasio.clases.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import cl.gimnasio.clases.controller.ClaseControllerV2;
import cl.gimnasio.clases.dto.ClaseDTO;

@Component
public class ClaseModelAssembler implements RepresentationModelAssembler<ClaseDTO, EntityModel<ClaseDTO>> {

    @Override
    public EntityModel<ClaseDTO> toModel(ClaseDTO dto) {
        return EntityModel.of(dto,
                linkTo(methodOn(ClaseControllerV2.class).getClaseById(dto.getId())).withSelfRel(),
                linkTo(methodOn(ClaseControllerV2.class).getAllClases()).withRel("clases"));
    }
}
