package com.sabino.gerenciaatividade.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClienteEntity {
    private String nome;
    private String sobrenome;
    private String dataDeNascimento;
    private String email;
    private String senha;
}
