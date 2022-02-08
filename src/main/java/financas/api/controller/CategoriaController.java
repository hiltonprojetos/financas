/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package financas.api.controller;

import financas.api.assembler.GenericAssembler;
import financas.api.model.CategoriaDto;
import financas.domain.exception.NegocioException;
import financas.domain.model.Categoria;
import financas.domain.repository.CategoriaRepository;
import financas.domain.service.CategoriaService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private GenericAssembler assembler;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping()
    public CollectionModel<CategoriaDto> all() {
        return assembler.toCategoriaCollectionModel(categoriaService.listar());
    }

    @GetMapping("/{id}")
    public Categoria one(@PathVariable Integer id) {
        return categoriaService.buscarOuFalhar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Integer id, @Valid @RequestBody CategoriaDto input) {
        categoriaService.buscarOuFalhar(id); 
        input.setICategoria(id);
        Categoria categoriaAtual = categoriaService.editar(assembler.toCategoriaEntity(input));        
        CategoriaDto categoriaEdidata = assembler.toCategoriaModel(categoriaAtual);
        return ResponseEntity.status(HttpStatus.OK).body(categoriaEdidata);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> post(@Valid @RequestBody CategoriaDto input) {
        Categoria novaCategoria = categoriaService.novo(assembler.toCategoriaEntity(input));
        CategoriaDto novaCategoriaDto = assembler.toCategoriaModel(novaCategoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoriaDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        categoriaService.deletar(id);
    }

}
