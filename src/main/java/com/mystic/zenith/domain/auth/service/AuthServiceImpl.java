package com.mystic.zenith.domain.auth.service;

import com.mystic.zenith.domain.auth.dto.request.LoginRequestDto;
import com.mystic.zenith.domain.auth.dto.AuthResponseDto;
import com.mystic.zenith.domain.auth.dto.request.RegisterRequestDto;
import com.mystic.zenith.domain.auth.mapper.AuthMapper;
import com.mystic.zenith.domain.user.entity.UserEntity;
import com.mystic.zenith.domain.user.repository.UserRepository;
import com.mystic.zenith.shared.exception.EmailTakenException;
import com.mystic.zenith.shared.exception.UserNotFoundException;
import com.mystic.zenith.shared.exception.UsernameTakenException;
import com.mystic.zenith.shared.service.JwtService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthMapper authMapper;
    private final JwtService jwtService;

    @Override
    public AuthResponseDto login(LoginRequestDto user) {
        UserEntity userEntity = userRepository.findByEmail(user.getEmail())
                            .filter(candidate -> passwordEncoder.matches(user.getPassword(), candidate.getPassword() ))
                            .orElseThrow(UserNotFoundException::new);
        String token = jwtService.encode(user.getEmail());
        return authMapper.mapToAuthResponseDto(userEntity, token);
    }

    @Override
    @Transactional
    public AuthResponseDto register(RegisterRequestDto user) {
        // email
        // password

        userRepository.findByEmail(user.getEmail()).ifPresent(userEntity -> {
            throw new EmailTakenException();
        });

        userRepository.findByUsername(user.getUsername()).ifPresent(userEntity -> {
            throw new UsernameTakenException();
        });

        UserEntity userEntity = UserEntity.builder()
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .username(user.getUsername())
                .bio(null)
                .avatarUrl(null)
                .build();

        userRepository.save(userEntity);

        String token = jwtService.encode(user.getEmail());
        return authMapper.mapToAuthResponseDto(userEntity, token);
    }
}
