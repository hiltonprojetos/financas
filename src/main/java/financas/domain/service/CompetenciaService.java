/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */

package financas.domain.service;

import financas.domain.exception.EntidadeNaoEncontradaException;
import financas.domain.model.Competencia;
import financas.domain.repository.CompetenciaRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hilton
 */
@Service
public class CompetenciaService {

    @Autowired
    private CompetenciaRepository repository;

    public Competencia buscarOuFalhar(Integer id){        
        return repository.findById(id).orElseThrow(() ->
                new EntidadeNaoEncontradaException("Competencia não localizada!")
        );        
    }

    @Transactional
    public Competencia novo(Competencia input) {
        return repository.save(input);
    }

    @Transactional
    public Competencia editar(Competencia input) {
        return repository.save(input);
    }

    @Transactional
    public void deletar(Integer id) {
        buscarOuFalhar(id);
        repository.deleteById(id);
    }

    public List<?> listar() {
        return repository.findAll();
    }

}
