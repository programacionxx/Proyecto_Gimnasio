package cl.gimnasio.reservas.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import cl.gimnasio.reservas.controller.ReservaControllerV2;
import cl.gimnasio.reservas.dto.ReservaDTO;

@Component
public class ReservaModelAssembler implements RepresentationModelAssembler<ReservaDTO, EntityModel<ReservaDTO>> {

    @Override
    public EntityModel<ReservaDTO> toModel(ReservaDTO dto) {
        return EntityModel.of(dto,
                linkTo(methodOn(ReservaControllerV2.class).getReservaById(dto.getId())).withSelfRel(),
                linkTo(methodOn(ReservaControllerV2.class).getAllReservas()).withRel("reservas"));
    }
}
