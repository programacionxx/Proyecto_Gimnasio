package cl.gimnasio.autenticacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.web.bind.annotation.*;

import cl.gimnasio.autenticacion.assemblers.UsuarioModelAssembler;
import cl.gimnasio.autenticacion.dto.UsuarioDTO;
import cl.gimnasio.autenticacion.service.AuthService;

@RestController
@RequestMapping("/api/auth/v2")
public class AuthControllerV2 {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioModelAssembler assembler;


    @GetMapping
    public CollectionModel<EntityModel<UsuarioDTO>> listarUsuarios() {
        List<EntityModel<UsuarioDTO>> usuarios = authService.listarUsuarios().stream()
                .map(UsuarioDTO::fromModel)
                .map(assembler::toModel)
                .toList();
        return CollectionModel.of(usuarios, linkTo(methodOn(AuthControllerV2.class).listarUsuarios()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<UsuarioDTO> obtenerUsuario(@PathVariable Long id) {
        UsuarioDTO usuario = UsuarioDTO.fromModel(authService.obtenerPorId(id));
        return assembler.toModel(usuario);
    }

}
