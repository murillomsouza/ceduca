package com.ceduca.dto;

import lombok.Data;

import java.util.List;

@Data
public class AlunoPatchDTO {

    private String nome;

    private String nomeSocial;

    private String telefone;

    private List<String> tags;
}