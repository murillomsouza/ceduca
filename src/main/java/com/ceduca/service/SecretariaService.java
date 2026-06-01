package com.ceduca.service;

import java.util.List;

import com.ceduca.dto.AlunoRequestDTO;
import com.ceduca.dto.AlunoResponseDTO;
import com.ceduca.dto.SecretariaPatchDTO;
import com.ceduca.dto.SecretariaRequestDTO;
import com.ceduca.dto.SecretariaResponseDTO;
import com.ceduca.model.Curriculo;

public interface SecretariaService {

        SecretariaResponseDTO criarSecretaria(
                        SecretariaRequestDTO dto);

        List<SecretariaResponseDTO> buscarSecretarias();

        SecretariaResponseDTO buscarSecretariaId(String id);

        SecretariaResponseDTO editarSecretaria(
                        String id,
                        SecretariaRequestDTO dto);

        void deletarSecretaria(String id);

        AlunoResponseDTO criarAluno(AlunoRequestDTO alunoDTO);

        List<AlunoResponseDTO> buscarAlunos();

        AlunoResponseDTO buscarAlunoId(String id);

        AlunoResponseDTO editarAluno(
                        String id,
                        AlunoRequestDTO alunoDTO);

        List<AlunoResponseDTO> buscarAlunosPorTag(String tag);

        Curriculo visualizarCurriculo(String alunoId);

        byte[] baixarCurriculo(String alunoId);

        SecretariaResponseDTO editarParcialSecretaria(
                        String id,
                        SecretariaPatchDTO dto);

        AlunoResponseDTO editarParcialAluno(
                        String id,
                        AlunoRequestDTO alunoDTO);

        Curriculo editarCurriculo(
                        String alunoId,
                        Curriculo curriculo);

        Curriculo editarParcialCurriculo(
                        String alunoId,
                        Curriculo curriculo);

        Curriculo criarCurriculo(
                        String alunoId,
                        Curriculo curriculo);
}