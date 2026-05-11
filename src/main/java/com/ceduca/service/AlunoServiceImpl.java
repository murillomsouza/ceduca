package com.ceduca.service;

import org.springframework.stereotype.Service;

import com.ceduca.model.Aluno;
import com.ceduca.model.Curriculo;
import com.ceduca.repository.AlunoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;

    @Override
    public Curriculo salvarCurriculo(String alunoId, Curriculo curriculo) {

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado."));

        aluno.setCurriculo(curriculo);

        alunoRepository.save(aluno);

        return curriculo;
    }

    @Override
    public Curriculo visualizarCurriculo(String alunoId) {

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado."));

        return aluno.getCurriculo();
    }

    @Override
    public Curriculo atualizarCurriculo(String alunoId, Curriculo curriculo) {

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado."));

        aluno.setCurriculo(curriculo);

        alunoRepository.save(aluno);

        return curriculo;
    }
}