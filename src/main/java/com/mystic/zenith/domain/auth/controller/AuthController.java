package com.mystic.zenith.domain.auth.controller;

import com.mystic.zenith.domain.auth.dto.request.LoginRequestDto;
import com.mystic.zenith.domain.auth.dto.request.RegisterRequestDto;
import com.mystic.zenith.domain.auth.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;

    @PostMapping("login")
    public ResponseEntity<?> login (@RequestBody LoginRequestDto user) {
        return ResponseEntity.ok(authService.login(user));
    }


    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDto user) {
        return ResponseEntity.ok(authService.register(user));
    }


}
