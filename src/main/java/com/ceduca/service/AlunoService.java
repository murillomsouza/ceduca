package com.ceduca.service;

import com.ceduca.dto.AlunoPatchDTO;
import com.ceduca.dto.AlunoResponseDTO;
import com.ceduca.model.Curriculo;

public interface AlunoService {

    Curriculo salvarCurriculo(String alunoId, Curriculo curriculo);

    Curriculo visualizarCurriculo(String alunoId);

    Curriculo atualizarCurriculo(String alunoId, Curriculo curriculo);

    AlunoResponseDTO editarParcialmente(
            String id,
            AlunoPatchDTO dto
    );
}