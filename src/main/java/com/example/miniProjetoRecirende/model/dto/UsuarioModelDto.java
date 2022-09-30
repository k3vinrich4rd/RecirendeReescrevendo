package com.example.miniProjetoRecirende.model.dto;

import com.example.miniProjetoRecirende.model.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModelDto implements Serializable {

    private Long id;
    private String nomeUsuario;
    private LocalDate dataDeNascimento;
    private String emailDoUsuario;
    private String telefone;
    private Integer pontosUsuario;

    public UsuarioModelDto(UsuarioModel obj) {
        this.id = obj.getId();
        this.nomeUsuario = obj.getNomeUsuario();
        this.dataDeNascimento = obj.getDataDeNascimento();
        this.emailDoUsuario = obj.getEmailDoUsuario();
        this.telefone = obj.getTelefone();
        this.pontosUsuario = obj.getPontosUsuario();
    }
}
