package com.example.miniProjetoRecirende.controller;

import com.example.miniProjetoRecirende.model.UsuarioModel;
import com.example.miniProjetoRecirende.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping(path = "/usuarios")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioModel> cadastrarUsuario(@Valid @RequestBody UsuarioModel usuarioModel) {
        UsuarioModel usuario = usuarioService.cadastrarUsuarios(usuarioModel);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }



}
