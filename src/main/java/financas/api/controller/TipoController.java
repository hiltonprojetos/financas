/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */

package financas.api.controller;

import financas.api.assembler.GenericAssembler;
import financas.api.model.TipoDto;
import financas.domain.model.Tipo;
import financas.domain.repository.TipoRepository;
import financas.domain.service.TipoService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/tipos")
public class TipoController {
    
    @Autowired
    private TipoService tipoService;
    
    @Autowired
    private GenericAssembler assembler;
    
    @GetMapping()
    public CollectionModel<TipoDto> all() {
        return assembler.toTipoCollectionModel(tipoService.listar());
    }

    @GetMapping("/{id}")
    public TipoDto one(@PathVariable Integer id) {
        return assembler.toTipoModel(tipoService.buscarOuFalhar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Integer id, @Valid @RequestBody TipoDto input) {
        tipoService.buscarOuFalhar(id); 
        input.setITipo(id);
        Tipo tipoAtual  = tipoService.editar(assembler.toTipoEntity(input));        
        TipoDto tipoEditado = assembler.toTipoModel(tipoAtual);
        return ResponseEntity.status(HttpStatus.OK).body(tipoEditado);
    }

    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody TipoDto input) {
        Tipo novoTipo = tipoService.novo(assembler.toTipoEntity(input));
        TipoDto novoTipoDto = assembler.toTipoModel(novoTipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoTipoDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        tipoService.deletar(id);
    }

}
