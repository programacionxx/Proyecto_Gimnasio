package cl.gimnasio.inventario.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import cl.gimnasio.inventario.controller.InventarioControllerV2;
import cl.gimnasio.inventario.dto.InventarioDTO;

@Component
public class InventarioModelAssembler implements RepresentationModelAssembler<InventarioDTO, EntityModel<InventarioDTO>> {

    @Override
    public EntityModel<InventarioDTO> toModel(InventarioDTO dto) {
        return EntityModel.of(dto,
                linkTo(methodOn(InventarioControllerV2.class).getInventarioById(dto.getId())).withSelfRel(),
                linkTo(methodOn(InventarioControllerV2.class).getAllInventario()).withRel("inventario"));
    }
}
