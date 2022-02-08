/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package financas.api.controller;


import financas.api.assembler.GenericAssembler;
import financas.api.model.UsuarioDto;
import financas.domain.model.Usuario;
import financas.domain.service.UsuarioService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Hilton
 */
@lombok.AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final GenericAssembler assembler;
    private final UsuarioService usuarioService;

    @GetMapping()
    public CollectionModel<UsuarioDto> all() {
        return assembler.toUsuarioCollectionModel(usuarioService.listar());
    }

    @GetMapping("/{id}")
    public UsuarioDto one(@PathVariable Integer id) {
        return buscarUsuarioDto(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Integer id, @Valid @RequestBody Usuario input) {
        usuarioService.buscarOuFalhar(id);
        input.setIUsuario(id);        
        Usuario usuarioEdicao = usuarioService.editarUsuario(input);
        UsuarioDto usuarioEditado = assembler.toUsuarioModel(usuarioEdicao);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioEditado);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> post(@Valid @RequestBody Usuario input) {
        Usuario novoUsuario = usuarioService.novoUsuario(input);
        UsuarioDto novoUsuarioDto = assembler.toUsuarioModel(novoUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuarioDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        usuarioService.deletarUsuario(id);
    }

    private UsuarioDto buscarUsuarioDto(Integer iUsuario) {
        return assembler.toUsuarioModel(usuarioService.buscarOuFalhar(iUsuario));
    }
}
