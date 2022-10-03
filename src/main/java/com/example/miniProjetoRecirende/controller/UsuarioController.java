package com.example.miniProjetoRecirende.controller;

import com.example.miniProjetoRecirende.model.UsuarioModel;
import com.example.miniProjetoRecirende.model.dto.UsuarioModelDto;
import com.example.miniProjetoRecirende.repository.IUsuarioRepository;
import com.example.miniProjetoRecirende.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Validated
@RequestMapping(path = "/usuarios")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @PostMapping
    public ResponseEntity<Object> cadastrarUsuario(@Valid @RequestBody UsuarioModel usuarioModel) {
        if (usuarioService.existsByCpfUsuario(usuarioModel.getCpfDoUsuario())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: Cpf já cadastrado");
        } else if (usuarioService.existsByEmailDoUsuario(usuarioModel.getEmailDoUsuario())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: E - mail já cadastrado");
        } else if (usuarioService.existsByTelefoneDoUsuario(usuarioModel.getTelefoneDoUsuario())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: Telefone já cadastrado");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastrarUsuarios(usuarioModel));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioModelDto>> exibirUsuarioCadastrados() {
        List<UsuarioModel> usuarioModelList = usuarioService.exibirUsuarios();
        List<UsuarioModelDto> usuarioModelDtos = usuarioModelList.stream().map(obj -> new UsuarioModelDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(usuarioModelDtos);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<UsuarioModel>> exibirUsuarioViaId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.exibirUsuarioViaId(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UsuarioModel> alterarUsuariosCadastrados(@Valid @PathVariable Long id, @RequestBody UsuarioModel usuarioModel) {
        if (!iUsuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioService.alterarUsuarioCadastrado(usuarioModel, id));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Retorna o 204
    public ResponseEntity deletar(@PathVariable Long id) {
        if (!iUsuarioRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: Id não encontrado");

        }
        usuarioService.deletarUsuario(id);
        return null;
    }


}




