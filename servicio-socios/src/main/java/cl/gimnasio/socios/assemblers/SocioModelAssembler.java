package cl.gimnasio.socios.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import cl.gimnasio.socios.controller.SocioControllerV2;
import cl.gimnasio.socios.dto.SocioDTO;

@Component
public class SocioModelAssembler implements RepresentationModelAssembler<SocioDTO, EntityModel<SocioDTO>> {

    @Override
    public EntityModel<SocioDTO> toModel(SocioDTO dto) {
        return EntityModel.of(dto,
                linkTo(methodOn(SocioControllerV2.class).obtenerSocio(dto.getId())).withSelfRel(),
                linkTo(methodOn(SocioControllerV2.class).listarSocios()).withRel("socios"));
    }
}
