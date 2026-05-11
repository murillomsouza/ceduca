package com.ceduca.model;

import java.util.List;

import lombok.Data;

@Data
public class Curriculo {

    private String resumo;

    private String linkedin;

    private String github;

    private List<Formacao> formacoes;

    private List<Qualificacao> qualificacoes;

    private List<Experiencia> experiencias;
}