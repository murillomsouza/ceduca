package com.ceduca.service;

import java.util.List;

import com.ceduca.dto.AlunoRequestDTO;
import com.ceduca.dto.AlunoResponseDTO;
import com.ceduca.model.Curriculo;

public interface SecretariaService {

    AlunoResponseDTO criarAluno(AlunoRequestDTO alunoDTO);

    List<AlunoResponseDTO> buscarAlunos();

    AlunoResponseDTO buscarAlunoId(String id);

    AlunoResponseDTO editarAluno(String id, AlunoRequestDTO alunoDTO);

    List<AlunoResponseDTO> buscarAlunosPorTag(String tag);

    Curriculo visualizarCurriculo(String alunoId);

    byte[] baixarCurriculo(String alunoId);
}