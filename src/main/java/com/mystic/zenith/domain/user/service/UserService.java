package com.mystic.zenith.domain.user.service;

import com.mystic.zenith.domain.auth.entity.AuthUserDetails;
import com.mystic.zenith.domain.user.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface UserService {
    public UserDto getCurrentUser(AuthUserDetails auth);

    public UserDto getUserById(UUID id);
}
