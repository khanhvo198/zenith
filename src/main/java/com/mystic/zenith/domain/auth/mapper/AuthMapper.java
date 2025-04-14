package com.mystic.zenith.domain.auth.mapper;

import com.mystic.zenith.domain.auth.dto.AuthResponseDto;
import com.mystic.zenith.domain.user.dto.UserDto;
import com.mystic.zenith.domain.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuthMapper {

    private final ModelMapper mapper;

    public AuthResponseDto mapToAuthResponseDto (UserEntity user, String token) {
        UserDto userDto = mapper.map(user, UserDto.class);
        return AuthResponseDto.builder().token(token).user(userDto).build();
    }




}
