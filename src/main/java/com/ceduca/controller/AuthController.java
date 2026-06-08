package com.ceduca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ceduca.dto.LoginRequestDTO;
import com.ceduca.dto.LoginResponseDTO;
import com.ceduca.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody LoginRequestDTO dto) {

        return ResponseEntity.ok(authService.login(dto));
    }
}