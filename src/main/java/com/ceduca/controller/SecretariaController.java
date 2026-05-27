package com.ceduca.controller;

import java.util.List;

import jakarta.validation.Valid;

import com.ceduca.dto.AlunoRequestDTO;
import com.ceduca.dto.AlunoResponseDTO;
import com.ceduca.dto.SecretariaPatchDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.ceduca.model.Curriculo;
import com.ceduca.service.SecretariaService;

import lombok.RequiredArgsConstructor;

import com.ceduca.dto.SecretariaRequestDTO;
import com.ceduca.dto.SecretariaResponseDTO;

@RestController
@RequestMapping("/secretarias")
@RequiredArgsConstructor
public class SecretariaController {

        private final SecretariaService secretariaService;

        @PostMapping
        public ResponseEntity<SecretariaResponseDTO> criarSecretaria(
                        @Valid @RequestBody SecretariaRequestDTO dto) {

                return ResponseEntity.ok(
                                secretariaService.criarSecretaria(dto));
        }

        @GetMapping
        public ResponseEntity<List<SecretariaResponseDTO>> buscarSecretarias() {

                return ResponseEntity.ok(
                                secretariaService.buscarSecretarias());
        }

        @GetMapping("/{id}")
        public ResponseEntity<SecretariaResponseDTO> buscarSecretariaId(
                        @PathVariable String id) {

                return ResponseEntity.ok(
                                secretariaService.buscarSecretariaId(id));
        }

        @PutMapping("/{id}")
        public ResponseEntity<SecretariaResponseDTO> editarSecretaria(
                        @PathVariable String id,
                        @Valid @RequestBody SecretariaRequestDTO dto) {

                return ResponseEntity.ok(
                                secretariaService.editarSecretaria(id, dto));
        }

        @PatchMapping("/{id}")
        public ResponseEntity<SecretariaResponseDTO> editarParcialSecretaria(
                        @PathVariable String id,
                        @RequestBody SecretariaPatchDTO dto) {

                return ResponseEntity.ok(
                                secretariaService.editarParcialSecretaria(id, dto));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarSecretaria(
                        @PathVariable String id) {

                secretariaService.deletarSecretaria(id);

                return ResponseEntity.noContent().build();
        }

        @PostMapping("/alunos")
        public ResponseEntity<AlunoResponseDTO> criarAluno(
                        @Valid @RequestBody AlunoRequestDTO alunoDTO) {

                return ResponseEntity.ok(
                                secretariaService.criarAluno(alunoDTO));
        }

        @GetMapping("/alunos")
        public ResponseEntity<List<AlunoResponseDTO>> buscarAlunos() {

                return ResponseEntity.ok(
                                secretariaService.buscarAlunos());
        }

        @GetMapping("/alunos/{id}")
        public ResponseEntity<AlunoResponseDTO> buscarAlunoId(
                        @PathVariable String id) {

                return ResponseEntity.ok(
                                secretariaService.buscarAlunoId(id));
        }

        @PutMapping("/alunos/{id}")
        public ResponseEntity<AlunoResponseDTO> editarAluno(
                        @PathVariable String id,
                        @Valid @RequestBody AlunoRequestDTO alunoDTO) {

                return ResponseEntity.ok(
                                secretariaService.editarAluno(id, alunoDTO));
        }

        @PatchMapping("/alunos/{id}")
        public ResponseEntity<AlunoResponseDTO> editarParcialAluno(
                        @PathVariable String id,
                        @RequestBody AlunoRequestDTO alunoDTO) {

                return ResponseEntity.ok(
                                secretariaService.editarParcialAluno(id, alunoDTO));
        }

        @GetMapping("/alunos/tags")
        public ResponseEntity<List<AlunoResponseDTO>> buscarPorTag(
                        @RequestParam String tag) {

                return ResponseEntity.ok(
                                secretariaService.buscarAlunosPorTag(tag));
        }

        @GetMapping("/alunos/{alunoId}/curriculo")
        public ResponseEntity<Curriculo> visualizarCurriculo(
                        @PathVariable String alunoId) {

                return ResponseEntity.ok(
                                secretariaService.visualizarCurriculo(alunoId));
        }

        @PostMapping("/alunos/{alunoId}/curriculo")
        public ResponseEntity<Curriculo> criarCurriculo(
                        @PathVariable String alunoId,
                        @RequestBody Curriculo curriculo) {

                return ResponseEntity.ok(
                                secretariaService.criarCurriculo(alunoId, curriculo));
        }

        @PutMapping("/alunos/{alunoId}/curriculo")
        public ResponseEntity<Curriculo> editarCurriculo(
                        @PathVariable String alunoId,
                        @RequestBody Curriculo curriculo) {

                return ResponseEntity.ok(
                                secretariaService.editarCurriculo(alunoId, curriculo));
        }

        @PatchMapping("/alunos/{alunoId}/curriculo")
        public ResponseEntity<Curriculo> editarParcialCurriculo(
                        @PathVariable String alunoId,
                        @RequestBody Curriculo curriculo) {

                return ResponseEntity.ok(
                                secretariaService.editarParcialCurriculo(alunoId, curriculo));
        }

        @GetMapping("/alunos/{alunoId}/curriculo/download")
        public ResponseEntity<byte[]> baixarCurriculo(
                        @PathVariable String alunoId) {

                byte[] pdf = secretariaService.baixarCurriculo(alunoId);

                return ResponseEntity.ok()
                                .header(
                                                HttpHeaders.CONTENT_DISPOSITION,
                                                "attachment; filename=curriculo-" + alunoId + ".pdf")
                                .contentType(MediaType.APPLICATION_PDF)
                                .body(pdf);
        }
}