package com.ceduca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceduca.dto.AlunoPatchDTO;
import com.ceduca.dto.AlunoResponseDTO;
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
                                alunoService.salvarCurriculo(id, curriculo));
        }

        @GetMapping("/{id}/curriculo")
        public ResponseEntity<Curriculo> visualizarCurriculo(
                        @PathVariable String id) {

                return ResponseEntity.ok(
                                alunoService.visualizarCurriculo(id));
        }

        @PutMapping("/{id}/curriculo")
        public ResponseEntity<Curriculo> atualizarCurriculo(
                        @PathVariable String id,
                        @RequestBody Curriculo curriculo) {

                return ResponseEntity.ok(
                                alunoService.atualizarCurriculo(id, curriculo));
        }

        @PatchMapping("/{id}/curriculo")
        public ResponseEntity<Curriculo> atualizarParcialmenteCurriculo(
                        @PathVariable String id,
                        @RequestBody Curriculo curriculo) {

                return ResponseEntity.ok(
                                alunoService.atualizarParcialmenteCurriculo(id, curriculo));
        }
        
        @DeleteMapping("/{id}/curriculo")
        public ResponseEntity<Void> excluirCurriculo(
                @PathVariable String id) {

                alunoService.excluirCurriculo(id);

                return ResponseEntity.noContent().build();
        }

        @PatchMapping("/{id}")
        public ResponseEntity<AlunoResponseDTO> editarParcialmente(
                        @PathVariable String id,
                        @RequestBody AlunoPatchDTO dto) {

                return ResponseEntity.ok(
                                alunoService.editarParcialmente(id, dto));
        }
}