package com.mystic.zenith.domain.user.service;

import com.mystic.zenith.domain.auth.entity.AuthUserDetails;
import com.mystic.zenith.domain.user.dto.UserDto;
import com.mystic.zenith.domain.user.entity.UserEntity;
import com.mystic.zenith.domain.user.repository.UserRepository;
import com.mystic.zenith.shared.exception.UserNotFoundException;
import com.mystic.zenith.shared.mapper.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Mapper mapper;

    @Override
    public UserDto getCurrentUser(AuthUserDetails auth) {
        UserEntity user =  userRepository.findById(auth.getId()).orElseThrow(UserNotFoundException::new);
        return mapper.mapToResponse(user, UserDto.class);
    }

    @Override
    public UserDto getUserById(UUID id) {
        UserEntity user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        return mapper.mapToResponse(user, UserDto.class);
    }
}
