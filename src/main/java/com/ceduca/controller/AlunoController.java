package com.ceduca.controller;

import com.ceduca.dto.AlunoPatchDTO;
import com.ceduca.dto.AlunoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ceduca.model.Curriculo;
import com.ceduca.service.AlunoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/aluno")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping("/{id}/curriculo")
    public ResponseEntity<Curriculo> salvarCurriculo(
            @PathVariable String id,
            @RequestBody Curriculo curriculo) {

        return ResponseEntity.ok(
                alunoService.salvarCurriculo(id, curriculo)
        );
    }

    @GetMapping("/{id}/curriculo")
    public ResponseEntity<Curriculo> visualizarCurriculo(
            @PathVariable String id) {

        return ResponseEntity.ok(
                alunoService.visualizarCurriculo(id)
        );
    }

    @PutMapping("/{id}/curriculo")
    public ResponseEntity<Curriculo> atualizarCurriculo(
            @PathVariable String id,
            @RequestBody Curriculo curriculo) {

        return ResponseEntity.ok(
                alunoService.atualizarCurriculo(id, curriculo)
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> editarParcialmente(
            @PathVariable String id,
            @RequestBody AlunoPatchDTO dto) {

        return ResponseEntity.ok(
                alunoService.editarParcialmente(id, dto)
        );
    }
}