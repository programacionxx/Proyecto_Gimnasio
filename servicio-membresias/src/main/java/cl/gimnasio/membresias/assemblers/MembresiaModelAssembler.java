package cl.gimnasio.membresias.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import cl.gimnasio.membresias.controller.MembresiaControllerV2;
import cl.gimnasio.membresias.dto.MembresiaDTO;

@Component
public class MembresiaModelAssembler implements RepresentationModelAssembler<MembresiaDTO, EntityModel<MembresiaDTO>> {

    @Override
    public EntityModel<MembresiaDTO> toModel(MembresiaDTO dto) {
        return EntityModel.of(dto,
                linkTo(methodOn(MembresiaControllerV2.class).obtenerMembresia(dto.getId())).withSelfRel(),
                linkTo(methodOn(MembresiaControllerV2.class).listarMembresias()).withRel("membresias"));
    }
}
