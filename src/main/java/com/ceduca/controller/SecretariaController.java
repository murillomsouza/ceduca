package com.ceduca.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ceduca.model.Aluno;
import com.ceduca.model.Curriculo;
import com.ceduca.service.SecretariaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/secretaria")
@RequiredArgsConstructor
public class SecretariaController {

    private final SecretariaService secretariaService;

    @PostMapping("/alunos")
    public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.ok(secretariaService.criarAluno(aluno));
    }

    @GetMapping("/alunos")
    public ResponseEntity<List<Aluno>> buscarAlunos() {
        return ResponseEntity.ok(secretariaService.buscarAlunos());
    }

    @GetMapping("/alunos/{id}")
    public ResponseEntity<Aluno> buscarAlunoId(@PathVariable String id) {
        return ResponseEntity.ok(secretariaService.buscarAlunoId(id));
    }

    @PutMapping("/alunos/{id}")
    public ResponseEntity<Aluno> editarAluno(
            @PathVariable String id,
            @RequestBody Aluno alunoAtualizado) {

        return ResponseEntity.ok(
                secretariaService.editarAluno(id, alunoAtualizado)
        );
    }

    @GetMapping("/alunos/tags")
    public ResponseEntity<List<Aluno>> buscarPorTag(
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