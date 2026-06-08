package com.ceduca.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "alunos")
@Data
public class Aluno {

    @Id
    private String id;

    private String nome;

    @Indexed(unique = true)
    private String email;

    private String senha;

    private String telefone;

    private List<String> tags;

    private Curriculo curriculo;
}