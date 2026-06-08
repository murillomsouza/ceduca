package com.ceduca.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ceduca.dto.LoginRequestDTO;
import com.ceduca.dto.LoginResponseDTO;
import com.ceduca.model.Aluno;
import com.ceduca.repository.AlunoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AlunoRepository alunoRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public LoginResponseDTO login(LoginRequestDTO dto) {

        Aluno aluno = alunoRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Email ou senha inválidos."));

        if (!passwordEncoder.matches(dto.getSenha(), aluno.getSenha())) {
            throw new RuntimeException("Email ou senha inválidos.");
        }

        LoginResponseDTO response = new LoginResponseDTO();

        response.setId(aluno.getId());
        response.setNome(aluno.getNome());
        response.setEmail(aluno.getEmail());

        return response;
    }
}