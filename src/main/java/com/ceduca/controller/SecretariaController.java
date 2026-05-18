package com.ceduca.controller;

import java.util.List;

import jakarta.validation.Valid;

import com.ceduca.dto.AlunoRequestDTO;
import com.ceduca.dto.AlunoResponseDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ceduca.model.Curriculo;
import com.ceduca.service.SecretariaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/secretaria")
@RequiredArgsConstructor
public class SecretariaController {

    private final SecretariaService secretariaService;

    @PostMapping("/alunos")
    public ResponseEntity<AlunoResponseDTO> criarAluno(
            @Valid @RequestBody AlunoRequestDTO alunoDTO) {

        return ResponseEntity.ok(
                secretariaService.criarAluno(alunoDTO)
        );
    }

    @GetMapping("/alunos")
    public ResponseEntity<List<AlunoResponseDTO>> buscarAlunos() {

        return ResponseEntity.ok(
                secretariaService.buscarAlunos()
        );
    }

    @GetMapping("/alunos/{id}")
    public ResponseEntity<AlunoResponseDTO> buscarAlunoId(
            @PathVariable String id) {

        return ResponseEntity.ok(
                secretariaService.buscarAlunoId(id)
        );
    }

    @PutMapping("/alunos/{id}")
    public ResponseEntity<AlunoResponseDTO> editarAluno(
            @PathVariable String id,
            @Valid @RequestBody AlunoRequestDTO alunoDTO) {

        return ResponseEntity.ok(
                secretariaService.editarAluno(id, alunoDTO)
        );
    }

    @GetMapping("/alunos/tags")
    public ResponseEntity<List<AlunoResponseDTO>> buscarPorTag(
            @RequestParam String tag) {

        return ResponseEntity.ok(
                secretariaService.buscarAlunosPorTag(tag)
        );
    }

    @GetMapping("/alunos/{alunoId}/curriculo")
    public ResponseEntity<Curriculo> visualizarCurriculo(
            @PathVariable String alunoId) {

        return ResponseEntity.ok(
                secretariaService.visualizarCurriculo(alunoId)
        );
    }

    @GetMapping("/alunos/{alunoId}/curriculo/download")
    public ResponseEntity<byte[]> baixarCurriculo(
            @PathVariable String alunoId) {

        return ResponseEntity.ok(
                secretariaService.baixarCurriculo(alunoId)
        );
    }
}