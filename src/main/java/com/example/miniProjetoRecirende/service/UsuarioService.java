package com.example.miniProjetoRecirende.service;

import com.example.miniProjetoRecirende.exception.EntityNotFoundException;
import com.example.miniProjetoRecirende.model.UsuarioModel;
import com.example.miniProjetoRecirende.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    public UsuarioModel cadastrarUsuarios(UsuarioModel usuarioModel) {
        return iUsuarioRepository.save(usuarioModel);
    }

    public UsuarioModel incrementarPontos(UsuarioModel usuarioModel, Integer pontos) {
        usuarioModel.setPontosUsuario(usuarioModel.getPontosUsuario() + pontos);
        return iUsuarioRepository.save(usuarioModel);
    }

    public List<UsuarioModel> exibirUsuarios() {
        return iUsuarioRepository.findAll();
    }

    public Optional<UsuarioModel> exibirUsuarioViaId(Long id) {
        return Optional.ofNullable(iUsuarioRepository.findById(id).orElseThrow((() -> new EntityNotFoundException("Erro: id não encontrado, impossivel efetuar busca pelo id " + id))));
    }

    public void deletarUsuario(Long id) {
        iUsuarioRepository.deleteById(id);
    }

    public UsuarioModel alterarUsuarioCadastrado(UsuarioModel usuarioModel, Long id) {
        iUsuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Erro: id não encontrado, impossivel efetuar uma alteração " + id));
        return iUsuarioRepository.save(usuarioModel);
    }

    //Validação(Query method)
    public boolean existsByCpfUsuario(String cpfUsuario) {
        return iUsuarioRepository.existsByCpfDoUsuario(cpfUsuario);
    }

    public boolean existsByEmailDoUsuario(String existsByEmailDoUsuario) {
        return iUsuarioRepository.existsByEmailDoUsuario(existsByEmailDoUsuario);
    }

    public boolean existsByTelefoneDoUsuario(String existsByTelefoneDoUsuario) {
        return iUsuarioRepository.existsByTelefoneDoUsuario(existsByTelefoneDoUsuario);
    }

}
