package com.example.miniProjetoRecirende.controller;

import com.example.miniProjetoRecirende.model.EmbalagemSalgadinhoModel;
import com.example.miniProjetoRecirende.repository.IEmbalagemSalgadinhoRepository;
import com.example.miniProjetoRecirende.service.EmbalagemSalgadinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(path = "/embalagens")

public class EmbalagemSalgadinhoController {

    @Autowired
    private EmbalagemSalgadinhoService embalagemSalgadinhoService;

    @Autowired
    private IEmbalagemSalgadinhoRepository iEmbalagemSalgadinhoRepository;

    @PostMapping
    public ResponseEntity<Object> cadastrarEmbalagens(@Valid @RequestBody EmbalagemSalgadinhoModel embalagemSalgadinhoModel) {
        if (embalagemSalgadinhoService.existsByNumeroDeSerieEmbalagem(embalagemSalgadinhoModel.getNumeroDeSerieEmbalagem())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: Número de série já cadastrado");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(embalagemSalgadinhoService.cadastrarEmbalagens(embalagemSalgadinhoModel));
    }

    @GetMapping
    public ResponseEntity<List<EmbalagemSalgadinhoModel>> exibirEmbalagensCadastradas() {
        return ResponseEntity.ok(embalagemSalgadinhoService.exibirEmbalagensCadastradas());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<EmbalagemSalgadinhoModel>> exibirEmbalagensViaId(@PathVariable Long id) {
        return ResponseEntity.ok(embalagemSalgadinhoService.exibirEmbalagensViaId(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EmbalagemSalgadinhoModel> alterarEmbalagensCadastradas(@Valid @PathVariable Long id, EmbalagemSalgadinhoModel embalagemSalgadinhoModel) {
        if (!iEmbalagemSalgadinhoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(embalagemSalgadinhoService.alterarEmbalagensCadastradas(embalagemSalgadinhoModel, id));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity deletarEmbalagensCadastradas(@PathVariable Long id) {
        if (!iEmbalagemSalgadinhoRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Id não encontrado");

        }
        embalagemSalgadinhoService.deletarEmbalagemCadastradas(id);
        return ResponseEntity.ok(embalagemSalgadinhoService);
    }

}
