/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */

package financas.api.controller;

import financas.api.assembler.GenericAssembler;
import financas.api.model.SaldoDto;
import financas.domain.model.Saldo;
import financas.domain.service.SaldoService;
import financas.domain.validation.ValidationGroups;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Hilton
 */
@RestController
@RequestMapping("/saldos")
public class SaldoController {
    
    @Autowired
    private SaldoService saldoService;
    
    @Autowired
    private GenericAssembler assembler;

    @GetMapping()
    public CollectionModel<?> all() {
        return assembler.toSaldoCollectionModel(saldoService.listar());
    }

    @GetMapping("/{id}")
    public SaldoDto one(@PathVariable Integer id) {
        Saldo saldo = saldoService.buscarOuFalhar(id);        
        return assembler.toSaldoModel(saldo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Integer id,
            @RequestBody @Valid SaldoDto input) {
        saldoService.buscarOuFalhar(id); 
        input.setISaldo(id);
        Saldo saldoEdicao = assembler.toSaldoEntity(input);
        saldoEdicao = saldoService.editar(saldoEdicao);
        return ResponseEntity.ok(assembler.toSaldoModel(saldoEdicao));
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody @Valid SaldoDto input) {
        Saldo saldoNovo = assembler.toSaldoEntity(input);
        saldoNovo = saldoService.novo(saldoNovo);
        return ResponseEntity.status(HttpStatus.CREATED).body(assembler.toSaldoModel(saldoNovo));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        saldoService.buscarOuFalhar(id);
        saldoService.deletar(id);
    }

}
