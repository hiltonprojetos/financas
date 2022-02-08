/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package financas.domain.service;

import financas.api.model.CategoriaDto;
import financas.domain.exception.EntidadeNaoEncontradaException;
import financas.domain.exception.NegocioException;
import financas.domain.model.Categoria;
import financas.domain.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hilton
 */
@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public Categoria buscarOuFalhar(Integer id){        
        return categoriaRepository.findById(id).orElseThrow(() ->
                new EntidadeNaoEncontradaException("Categoria não localizada!")
        );        
    }

    @Transactional
    public Categoria novo(Categoria input) {
        return categoriaRepository.save(input);
    }

    @Transactional
    public Categoria editar(Categoria input) {
        return categoriaRepository.save(input);
    }

    @Transactional
    public void deletar(Integer id) {
        buscarOuFalhar(id);
        categoriaRepository.deleteById(id);
    }

    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }
}
