package cl.gimnasio.autenticacion.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import cl.gimnasio.autenticacion.controller.AuthControllerV2;
import cl.gimnasio.autenticacion.dto.UsuarioDTO;

@Component
public class UsuarioModelAssembler implements RepresentationModelAssembler<UsuarioDTO, EntityModel<UsuarioDTO>> {

    @Override
    public EntityModel<UsuarioDTO> toModel(UsuarioDTO dto) {
        return EntityModel.of(dto,
                linkTo(methodOn(AuthControllerV2.class).obtenerUsuario(dto.getId())).withSelfRel(),
                linkTo(methodOn(AuthControllerV2.class).listarUsuarios()).withRel("usuarios"));
    }
}
