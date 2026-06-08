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
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado."));

        aluno.setCurriculo(curriculo);

        alunoRepository.save(aluno);

        return curriculo;
    }

    @Override
    public Curriculo atualizarCurriculo(
            String alunoId,
            Curriculo curriculoAtualizado) {

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado."));

        aluno.setCurriculo(curriculoAtualizado);

        alunoRepository.save(aluno);

        return curriculoAtualizado;
    }

    @Override
    public Curriculo visualizarCurriculo(String alunoId) {

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado."));

        return aluno.getCurriculo();
    }

    @Override
    public AlunoResponseDTO editarParcialmente(
            String id,
            AlunoPatchDTO dto) {

        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado."));

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

    @Override
    public Curriculo atualizarParcialmenteCurriculo(
            String alunoId,
            Curriculo curriculoAtualizado) {

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado."));

        Curriculo curriculo = aluno.getCurriculo();

        if (curriculo == null) {
            throw new RuntimeException("Currículo não encontrado.");
        }

        if (curriculoAtualizado.getNomeSocial() != null) {
            curriculo.setNomeSocial(curriculoAtualizado.getNomeSocial());
        }

        if (curriculoAtualizado.getDataNascimento() != null) {
            curriculo.setDataNascimento(curriculoAtualizado.getDataNascimento());
        }

        if (curriculoAtualizado.getLinkedin() != null) {
            curriculo.setLinkedin(curriculoAtualizado.getLinkedin());
        }

        if (curriculoAtualizado.getEndereco() != null) {
            curriculo.setEndereco(curriculoAtualizado.getEndereco());
        }

        if (curriculoAtualizado.getCidade() != null) {
            curriculo.setCidade(curriculoAtualizado.getCidade());
        }

        if (curriculoAtualizado.getResumo() != null) {
            curriculo.setResumo(curriculoAtualizado.getResumo());
        }

        if (curriculoAtualizado.getPossuiExperiencia() != null) {
            curriculo.setPossuiExperiencia(
                    curriculoAtualizado.getPossuiExperiencia());
        }

        if (curriculoAtualizado.getFormacoes() != null) {
            curriculo.setFormacoes(curriculoAtualizado.getFormacoes());
        }

        if (curriculoAtualizado.getQualificacoes() != null) {
            curriculo.setQualificacoes(
                    curriculoAtualizado.getQualificacoes());
        }

        if (curriculoAtualizado.getExperiencias() != null) {
            curriculo.setExperiencias(
                    curriculoAtualizado.getExperiencias());
        }

        alunoRepository.save(aluno);

        return curriculo;
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

    @Override
    public void excluirCurriculo(String alunoId) {

        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado."));

        if (aluno.getCurriculo() == null) {
            throw new RuntimeException("Currículo não encontrado.");
        }

        aluno.setCurriculo(null);

        alunoRepository.save(aluno);
    }
}