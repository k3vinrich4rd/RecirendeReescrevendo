package com.example.miniProjetoRecirende.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "embalagens")
public class EmbalagemSalgadinhoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca_salgadinho_embalagem", length = 50, nullable = false)
    @NotBlank(message = "Erro: o campo 'marca salgadinho' não foi informado")
    private String marcaSalgadinho;

    @Column(name = "numero_de_serie_embalagem", length = 9, nullable = false)
    @Length(max = 9, message = "Erro, o campo 'numero de serie embalagem' deve conter no maximo 9 digitos")
    @Length(min = 9, message = "Erro, o campo 'numero de serie embalagem' deve conte no minimo 9 digitos")
    private String numeroDeSerieEmbalagem;


}
