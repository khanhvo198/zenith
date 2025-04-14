package com.mystic.zenith.domain.user.mapper;

import com.mystic.zenith.domain.user.dto.UserDto;
import com.mystic.zenith.domain.user.dto.response.UserResponseDto;
import com.mystic.zenith.domain.user.entity.UserEntity;
import com.mystic.zenith.shared.mapper.Mapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;
    private final Mapper mapper;

    public UserResponseDto mapToUserResponseDto (UserEntity user) {
        UserDto userDto = mapper.mapToResponse(user, UserDto.class);
        return UserResponseDto.builder().user(userDto).build();
    }

}
