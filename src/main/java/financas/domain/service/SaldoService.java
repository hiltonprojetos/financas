/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */

package financas.domain.service;

import financas.domain.exception.EntidadeNaoEncontradaException;
import financas.domain.model.Saldo;
import financas.domain.repository.SaldoRepository;
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
public class SaldoService {

    @Autowired
    private SaldoRepository repository;

    public Saldo buscarOuFalhar(Integer id){        
        return repository.findById(id).orElseThrow(() ->
                new EntidadeNaoEncontradaException("Saldo não localizado!")
        );        
    }

    @Transactional
    public Saldo novo(Saldo input) {
        return repository.save(input);
    }

    @Transactional
    public Saldo editar(Saldo input) {
        return repository.save(input);
    }

    @Transactional
    public void deletar(Integer id) {
        buscarOuFalhar(id);
        repository.deleteById(id);
    }

    public List<Saldo> listar() {
        return repository.findAll();
    }

}
