package com.example.miniProjetoRecirende.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UsuarioModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_usuario", length = 75, nullable = false)
    @NotBlank(message = "Erro: o campo 'nome' não foi informado")
    private String nomeUsuario;

    @Column(name = "data_de_nascimento_usuario", length = 10)
    @NotNull(message = "Erro: o campo 'data de nascimento' não foi informado")
    private LocalDate dataDeNascimento;

    @Column(name = "cpf_usuario", length = 14, nullable = false)
    @CPF(message = "Erro, 'cpf' inválido")
    @NotBlank(message = "Erro, o campo 'cpf' não foi informado")
    private String cpfDoUsuario;

    @Column(name = "email_usuario", length = 50, nullable = false)
    @Email(message = "Erro, 'e-mail' inválido")
    @NotBlank(message = "Erro, o campo 'e-mail' não foi informado")
    private String emailDoUsuario;

    @Column(name = "telefone_usuario", nullable = false)
    @Length(max = 10, message = "Erro, o campo 'telefone' deve conter no maximo 12 digitos")
    @Length(min = 9, message = "Erro, o campo 'telefone' deve conte no minimo 9 digitos")
    @NotBlank(message = "Erro, campo 'telefone' não informado")
    private String telefone;

    @Column(name = "ponto_usuario")
    private Integer pontosUsuario = 0;

}
