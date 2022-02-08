/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */

package financas.domain.service;

import financas.domain.exception.EntidadeNaoEncontradaException;
import financas.domain.model.Tipo;
import financas.domain.repository.TipoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hilton
 */
@Service
public class TipoService {

    @Autowired
    private TipoRepository repository;

    public Tipo buscarOuFalhar(Integer id){        
        return repository.findById(id).orElseThrow(() ->
                new EntidadeNaoEncontradaException("Tipo não localizado!")
        );        
    }

    @Transactional
    public Tipo novo(Tipo input) {
        return repository.save(input);
    }

    @Transactional
    public Tipo editar(Tipo input) {
        return repository.save(input);
    }

    @Transactional
    public void deletar(Integer id) {
        buscarOuFalhar(id);
        repository.deleteById(id);
    }

    public List<Tipo> listar() {
        return repository.findAll();
    }

}
