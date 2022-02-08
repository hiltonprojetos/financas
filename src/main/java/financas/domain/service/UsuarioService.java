/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package financas.domain.service;

import financas.api.model.UsuarioDto;
import financas.domain.exception.EntidadeEmUsoException;
import financas.domain.exception.NegocioException;
import financas.domain.exception.UsuarioNaoEcontradoException;
import financas.domain.model.Usuario;
import financas.domain.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hilton
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarOuFalhar(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(()
                -> new UsuarioNaoEcontradoException(id)
        );
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario novoUsuario(Usuario usuario) {
        camposValidos(usuario);
        usuario.setAtivo(true);
        usuario.setPerfil("OPERADOR");
        Usuario usuarioNovo = usuarioRepository.save(usuario);
        return usuario;
    }

    @Transactional
    public Usuario editarUsuario(Usuario usuario) {
        camposValidos(usuario);
        Usuario usuarioNovo = usuarioRepository.save(buscarOuFalhar(usuario.getIUsuario()));
        return usuario;
    }    
    

    @Transactional
    public void deletarUsuario(Integer id) {
        try {
            usuarioRepository.deleteById(buscarOuFalhar(id).getIUsuario());
        } catch (EmptyResultDataAccessException e) {
            throw new UsuarioNaoEcontradoException(id);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(
                    "Usuário de código %d não pode ser removido, pois está em uso", id));
        }
    }
    
    private void camposValidos(Usuario novoUsuario) {
        boolean loginEmUso = usuarioRepository.findByNlogin(novoUsuario.getNlogin())
                .stream().anyMatch(usuarioExistente -> !usuarioExistente.equals(novoUsuario));
        if (loginEmUso) {
            throw new NegocioException("Já existe um usuário cadastrado este login");
        }
        boolean emailEmUso = usuarioRepository.findByEmail(novoUsuario.getEmail())
                .stream().anyMatch(usuarioExistente -> !usuarioExistente.equals(novoUsuario));
        if (emailEmUso) {
            throw new NegocioException("Já existe um usuário cadastrado com este e-mail");
        }
    }

}
