package com.ceduca.model;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class Curriculo {

    private String nomeSocial;

    private LocalDate dataNascimento;

    private String linkedin;

    private String endereco;

    private String cidade;

    private String resumo;

    private Boolean possuiExperiencia;

    private List<Formacao> formacoes;

    private List<Qualificacao> qualificacoes;

    private List<Experiencia> experiencias;
}