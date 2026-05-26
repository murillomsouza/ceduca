package com.ceduca.service;

import org.springframework.stereotype.Service;

import com.ceduca.dto.AlunoPatchDTO;
import com.ceduca.dto.AlunoResponseDTO;
import com.ceduca.model.Aluno;
import com.ceduca.model.Curriculo;
import com.ceduca.repository.AlunoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;

    @Override
    public Curriculo salvarCurriculo(
            String alunoId,
            Curriculo curriculo) {

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado."));

        aluno.setCurriculo(curriculo);

        alunoRepository.save(aluno);

        return curriculo;
    }

    @Override
    public Curriculo atualizarCurriculo(
            String alunoId,
            Curriculo curriculoAtualizado) {

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado."));

        aluno.setCurriculo(curriculoAtualizado);

        alunoRepository.save(aluno);

        return curriculoAtualizado;
    }

    @Override
    public Curriculo visualizarCurriculo(String alunoId) {

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado."));

        return aluno.getCurriculo();
    }

    @Override
    public AlunoResponseDTO editarParcialmente(
            String id,
            AlunoPatchDTO dto) {

        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado."));

        if (dto.getNome() != null) {
            aluno.setNome(dto.getNome());
        }

        if (dto.getTelefone() != null) {
            aluno.setTelefone(dto.getTelefone());
        }

        if (dto.getTags() != null) {
            aluno.setTags(dto.getTags());
        }

        Aluno alunoAtualizado = alunoRepository.save(aluno);

        return toResponseDTO(alunoAtualizado);
    }

    private AlunoResponseDTO toResponseDTO(Aluno aluno) {

        AlunoResponseDTO dto = new AlunoResponseDTO();

        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setEmail(aluno.getEmail());
        dto.setTelefone(aluno.getTelefone());
        dto.setTags(aluno.getTags());

        return dto;
    }
}