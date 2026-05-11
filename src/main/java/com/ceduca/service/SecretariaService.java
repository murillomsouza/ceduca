package com.ceduca.service;

import java.util.List;

import com.ceduca.model.Aluno;
import com.ceduca.model.Curriculo;

public interface SecretariaService {

    Aluno criarAluno(Aluno aluno);

    List<Aluno> buscarAlunos();

    Aluno buscarAlunoId(String id);

    Aluno editarAluno(String id, Aluno alunoAtualizado);

    List<Aluno> buscarAlunosPorTag(String tag);

    Curriculo visualizarCurriculo(String alunoId);

    byte[] baixarCurriculo(String alunoId);
}
