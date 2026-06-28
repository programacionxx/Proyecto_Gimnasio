package cl.gimnasio.pagos.assemblers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import cl.gimnasio.pagos.controller.PagoControllerV2;
import cl.gimnasio.pagos.dto.PagoDTO;

@Component
public class PagoModelAssembler implements RepresentationModelAssembler<PagoDTO, EntityModel<PagoDTO>> {

    @Override
    public EntityModel<PagoDTO> toModel(PagoDTO dto) {
        return EntityModel.of(dto,
                linkTo(methodOn(PagoControllerV2.class).getPagoById(dto.getId())).withSelfRel(),
                linkTo(methodOn(PagoControllerV2.class).getAllPagos()).withRel("pagos"));
    }
}
