package com.ceduca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ceduca.service.pdf.CurriculoPdfService;
import com.ceduca.dto.AlunoRequestDTO;
import com.ceduca.dto.AlunoResponseDTO;
import com.ceduca.dto.SecretariaRequestDTO;
import com.ceduca.dto.SecretariaResponseDTO;
import com.ceduca.model.Aluno;
import com.ceduca.model.Curriculo;
import com.ceduca.model.Secretaria;
import com.ceduca.repository.AlunoRepository;
import com.ceduca.repository.SecretariaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecretariaServiceImpl implements SecretariaService {

    private final CurriculoPdfService curriculoPdfService;
    private final AlunoRepository alunoRepository;
    private final SecretariaRepository secretariaRepository;

    @Override
    public SecretariaResponseDTO criarSecretaria(
            SecretariaRequestDTO dto) {

        if (secretariaRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email já cadastrado.");
        }

        Secretaria secretaria = new Secretaria();

        secretaria.setNome(dto.getNome());
        secretaria.setEmail(dto.getEmail());
        secretaria.setSenha(dto.getSenha());
        secretaria.setTipoUsuario(dto.getTipoUsuario());

        Secretaria secretariaSalva =
                secretariaRepository.save(secretaria);

        return toSecretariaResponseDTO(secretariaSalva);
    }

    @Override
    public List<SecretariaResponseDTO> buscarSecretarias() {

        return secretariaRepository.findAll()
                .stream()
                .map(this::toSecretariaResponseDTO)
                .toList();
    }

    @Override
    public SecretariaResponseDTO buscarSecretariaId(String id) {

        Secretaria secretaria = secretariaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Secretaria não encontrada."));

        return toSecretariaResponseDTO(secretaria);
    }

    @Override
    public SecretariaResponseDTO editarSecretaria(
            String id,
            SecretariaRequestDTO dto) {

        Secretaria secretaria = secretariaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Secretaria não encontrada."));

        secretaria.setNome(dto.getNome());
        secretaria.setEmail(dto.getEmail());
        secretaria.setSenha(dto.getSenha());
        secretaria.setTipoUsuario(dto.getTipoUsuario());

        Secretaria secretariaAtualizada =
                secretariaRepository.save(secretaria);

        return toSecretariaResponseDTO(secretariaAtualizada);
    }

    @Override
    public void deletarSecretaria(String id) {

        Secretaria secretaria = secretariaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Secretaria não encontrada."));

        secretariaRepository.delete(secretaria);
    }

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

        return curriculoPdfService.gerarPdf(aluno);
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

    private SecretariaResponseDTO toSecretariaResponseDTO(
            Secretaria secretaria) {

        SecretariaResponseDTO dto =
                new SecretariaResponseDTO();

        dto.setId(secretaria.getId());
        dto.setNome(secretaria.getNome());
        dto.setEmail(secretaria.getEmail());
        dto.setTipoUsuario(secretaria.getTipoUsuario());

        return dto;
    }
}