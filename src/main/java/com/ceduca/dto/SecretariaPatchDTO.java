package com.ceduca.dto;

import lombok.Data;

@Data
public class SecretariaPatchDTO {

    private String nome;

    private String email;

    private String senha;

    private String tipoUsuario;
}