package com.ceduca.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AlunoRequestDTO {

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    private String nomeSocial;

    @Email(message = "Email inválido.")
    @NotBlank(message = "O email é obrigatório.")
    private String email;

    @NotBlank(message = "O telefone é obrigatório.")
    private String telefone;

    private List<String> tags;
}