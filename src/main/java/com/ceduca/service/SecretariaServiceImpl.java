package com.ceduca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ceduca.dto.AlunoRequestDTO;
import com.ceduca.dto.AlunoResponseDTO;
import com.ceduca.model.Aluno;
import com.ceduca.model.Curriculo;
import com.ceduca.repository.AlunoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecretariaServiceImpl implements SecretariaService {

    private final AlunoRepository alunoRepository;

    @Override
    public AlunoResponseDTO criarAluno(AlunoRequestDTO alunoDTO) {

        if (alunoRepository.existsByEmail(alunoDTO.getEmail())) {
            throw new RuntimeException("Email já cadastrado.");
        }

        Aluno aluno = new Aluno();

        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setTelefone(alunoDTO.getTelefone());
        aluno.setTags(alunoDTO.getTags());

        Aluno alunoSalvo = alunoRepository.save(aluno);

        return toResponseDTO(alunoSalvo);
    }

    @Override
    public List<AlunoResponseDTO> buscarAlunos() {

        return alunoRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public AlunoResponseDTO buscarAlunoId(String id) {

        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado."));

        return toResponseDTO(aluno);
    }

    @Override
    public AlunoResponseDTO editarAluno(
            String id,
            AlunoRequestDTO alunoDTO) {

        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado."));

        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setTelefone(alunoDTO.getTelefone());
        aluno.setTags(alunoDTO.getTags());

        Aluno alunoAtualizado = alunoRepository.save(aluno);

        return toResponseDTO(alunoAtualizado);
    }

    @Override
    public List<AlunoResponseDTO> buscarAlunosPorTag(String tag) {

        return alunoRepository.findByTagsContaining(tag)
                .stream()
                .map(this::toResponseDTO)
                .toList();
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