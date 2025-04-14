package com.mystic.zenith.domain.auth.service;

import com.mystic.zenith.domain.auth.dto.request.LoginRequestDto;
import com.mystic.zenith.domain.auth.dto.AuthResponseDto;
import com.mystic.zenith.domain.auth.dto.request.RegisterRequestDto;


public interface AuthService {
    public AuthResponseDto login(LoginRequestDto user);

    public AuthResponseDto register(RegisterRequestDto user);

}
