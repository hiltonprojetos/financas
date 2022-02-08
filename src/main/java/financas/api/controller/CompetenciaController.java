/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */

package financas.api.controller;

import financas.api.assembler.GenericAssembler;
import financas.api.model.CompetenciaDto;
import financas.domain.model.Competencia;
import financas.domain.service.CompetenciaService;
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
@RequestMapping("/competencias")
public class CompetenciaController {

    @Autowired
    private GenericAssembler assembler;
    
    @Autowired
    private CompetenciaService competenciaService;
    
    @GetMapping()
    public CollectionModel<CompetenciaDto> all() {
        return assembler.toCompetenciaCollectionModel((List<Competencia>) competenciaService.listar());
    }

    @GetMapping("/{id}")
    public CompetenciaDto one(@PathVariable Integer id) {
        return assembler.toCompetenciaModel(competenciaService.buscarOuFalhar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Integer id, @Valid @RequestBody CompetenciaDto input) {
        competenciaService.buscarOuFalhar(id);
        Competencia competenciaEdicao = assembler.toCompetenciaEntity(input);
        competenciaEdicao.setICompetencia(id);
        competenciaEdicao = competenciaService.editar(competenciaEdicao);
        return ResponseEntity.ok(assembler.toCompetenciaModel(competenciaEdicao));
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Competencia input) {
        Competencia competenciaNova = competenciaService.novo(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(assembler.toCompetenciaModel(competenciaNova));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        competenciaService.deletar(id);
    }

}
