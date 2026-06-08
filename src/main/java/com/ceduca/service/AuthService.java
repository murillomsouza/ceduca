package com.ceduca.service;

import com.ceduca.dto.LoginRequestDTO;
import com.ceduca.dto.LoginResponseDTO;

public interface AuthService {

    LoginResponseDTO login(LoginRequestDTO dto);

}