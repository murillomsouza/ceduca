package com.ceduca.dto;

import java.util.List;

import lombok.Data;

@Data
public class AlunoResponseDTO {

    private String id;

    private String nome;

    private String nomeSocial;

    private String email;

    private String telefone;

    private List<String> tags;
}