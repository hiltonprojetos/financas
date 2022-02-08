/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */

package financas.domain.service;

import financas.domain.exception.EntidadeNaoEncontradaException;
import financas.domain.model.Conta;
import financas.domain.repository.ContaRepository;
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
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta buscarOuFalhar(Integer id){        
        return contaRepository.findById(id).orElseThrow(() ->
                new EntidadeNaoEncontradaException("Conta não localizada!")
        );        
    }

    @Transactional
    public Conta novo(Conta input) {
        return contaRepository.save(input);
    }

    @Transactional
    public Conta editar(Conta input) {
        return contaRepository.save(input);
    }

    @Transactional
    public void deletar(Integer id) {
        buscarOuFalhar(id);
        contaRepository.deleteById(id);
    }

    public List<Conta> listar() {
        return contaRepository.findAll();
    }

}
