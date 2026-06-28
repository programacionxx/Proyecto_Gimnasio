package cl.gimnasio.entrenadores.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import cl.gimnasio.entrenadores.controller.EntrenadorControllerV2;
import cl.gimnasio.entrenadores.dto.EntrenadorDTO;

@Component
public class EntrenadorModelAssembler implements RepresentationModelAssembler<EntrenadorDTO, EntityModel<EntrenadorDTO>> {

    @Override
    public EntityModel<EntrenadorDTO> toModel(EntrenadorDTO dto) {
        return EntityModel.of(dto,
                linkTo(methodOn(EntrenadorControllerV2.class).getEntrenadorById(dto.getId())).withSelfRel(),
                linkTo(methodOn(EntrenadorControllerV2.class).getAllEntrenadores()).withRel("entrenadores"));
    }
}
