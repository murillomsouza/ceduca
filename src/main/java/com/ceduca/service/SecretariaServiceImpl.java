package com.ceduca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ceduca.model.Aluno;
import com.ceduca.model.Curriculo;
import com.ceduca.repository.AlunoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecretariaServiceImpl implements SecretariaService {

    private final AlunoRepository alunoRepository;

    @Override
    public Aluno criarAluno(Aluno aluno) {

        if (alunoRepository.existsByEmail(aluno.getEmail())) {
            throw new RuntimeException("Email já cadastrado.");
        }

        return alunoRepository.save(aluno);
    }

    @Override
    public List<Aluno> buscarAlunos() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno buscarAlunoId(String id) {

        return alunoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado."));
    }

    @Override
    public Aluno editarAluno(String id, Aluno alunoAtualizado) {

        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado."));

        aluno.setNome(alunoAtualizado.getNome());
        aluno.setEmail(alunoAtualizado.getEmail());
        aluno.setTelefone(alunoAtualizado.getTelefone());
        aluno.setTags(alunoAtualizado.getTags());

        return alunoRepository.save(aluno);
    }

    @Override
    public List<Aluno> buscarAlunosPorTag(String tag) {

        return alunoRepository.findByTagsContaining(tag);
    }

    @Override
    public Curriculo visualizarCurriculo(String alunoId) {

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado."));

        return aluno.getCurriculo();
    }

    @Override
    public byte[] baixarCurriculo(String alunoId) {

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado."));

        if (aluno.getCurriculo() == null) {
            throw new RuntimeException("Currículo não encontrado.");
        }

        // Implementação futura do PDF
        return new byte[0];
    }
}