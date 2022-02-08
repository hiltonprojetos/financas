/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */

package financas.api.controller;

import financas.api.assembler.GenericAssembler;
import financas.api.model.ContaDto;
import financas.domain.model.Conta;
import financas.domain.service.ContaService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Hilton
 */
@RestController
@RequestMapping("/contas")
public class ContaController {
    
    @Autowired
    private ContaService contaService;
    
    @Autowired
    private GenericAssembler assembler;

    @GetMapping()
    public CollectionModel<ContaDto> all() {
        return assembler.toContaCollectionModel(contaService.listar());
    }

    @GetMapping("/{id}")
    public ContaDto one(@PathVariable Integer id) {
        return assembler.toContaModel(contaService.buscarOuFalhar(id));
    }

    @PutMapping("/{id}")    
    public ResponseEntity<?> put(@PathVariable Integer id, @Valid @RequestBody ContaDto input) {
        contaService.buscarOuFalhar(id);
        Conta contaEdicao = assembler.toContaEntity(input);
        contaEdicao.setIConta(id);
        contaEdicao = contaService.editar(contaEdicao);
        ContaDto contaEditada = assembler.toContaModel(contaEdicao);        
        return ResponseEntity.ok(contaEditada);
    }

    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody ContaDto input) {        
        Conta contaNova = contaService.novo(assembler.toContaEntity(input));
        return ResponseEntity.status(HttpStatus.CREATED).body(assembler.toContaModel(contaNova));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        contaService.deletar(id);
    }

//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="Error message")
//    public void handleError() {
//    }

}
