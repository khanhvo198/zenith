package com.mystic.zenith.domain.user.service;

import com.mystic.zenith.domain.auth.entity.AuthUserDetails;
import com.mystic.zenith.domain.user.dto.UserDto;
import com.mystic.zenith.domain.user.dto.response.UserResponseDto;

import java.util.UUID;

public interface UserService {
    public UserResponseDto getCurrentUser(AuthUserDetails auth);

    public UserResponseDto getUserById(UUID id);
}
