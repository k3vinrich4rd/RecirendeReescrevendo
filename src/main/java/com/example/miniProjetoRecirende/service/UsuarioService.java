package com.example.miniProjetoRecirende.service;

import com.example.miniProjetoRecirende.model.UsuarioModel;
import com.example.miniProjetoRecirende.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    public UsuarioModel cadastrarUsuarios(UsuarioModel usuarioModel) {
        return iUsuarioRepository.save(usuarioModel);
    }
}
