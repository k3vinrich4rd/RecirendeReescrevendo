package com.example.miniProjetoRecirende.service;

import com.example.miniProjetoRecirende.exception.EntityNotFoundException;
import com.example.miniProjetoRecirende.model.EmbalagemSalgadinhoModel;
import com.example.miniProjetoRecirende.model.UsuarioModel;
import com.example.miniProjetoRecirende.repository.IEmbalagemSalgadinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmbalagemSalgadinhoService {

    @Autowired
    private IEmbalagemSalgadinhoRepository iEmbalagemSalgadinhoRepository;

    @Autowired
    UsuarioService usuarioService;

    public EmbalagemSalgadinhoModel cadastrarEmbalagens(EmbalagemSalgadinhoModel embalagemSalgadinhoModel) {
        embalagemSalgadinhoModel.getUsuarioModel().getId();
        UsuarioModel usuario = usuarioService.exibirUsuarioViaId(embalagemSalgadinhoModel.getUsuarioModel().getId()).orElseThrow();
        usuarioService.incrementarPontos(usuario, 1500);
        return iEmbalagemSalgadinhoRepository.save(embalagemSalgadinhoModel);
    }

    public List<EmbalagemSalgadinhoModel> exibirEmbalagensCadastradas() {
        return iEmbalagemSalgadinhoRepository.findAll();
    }

    public Optional<EmbalagemSalgadinhoModel> exibirEmbalagensViaId(Long id) {
        return Optional.ofNullable(iEmbalagemSalgadinhoRepository.findById(id).orElseThrow((() -> new EntityNotFoundException("Erro: id não encontrado, impossivel efetuar busca pelo id " + id))));
    }

    public EmbalagemSalgadinhoModel alterarEmbalagensCadastradas(EmbalagemSalgadinhoModel embalagemSalgadinhoModel, Long id) {
        iEmbalagemSalgadinhoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Erro: id não encontrado, impossivel efetuar uma alteração" + id));
        return iEmbalagemSalgadinhoRepository.save(embalagemSalgadinhoModel);
    }

    public void deletarEmbalagemCadastradas(Long id) {
        iEmbalagemSalgadinhoRepository.deleteById(id);
    }


    //Validação (Query Method):
    public boolean existsByNumeroDeSerieEmbalagem(String existsByNumeroDeSerieEmbalagem) {
        return iEmbalagemSalgadinhoRepository.existsByNumeroDeSerieEmbalagem(existsByNumeroDeSerieEmbalagem);
    }


}
