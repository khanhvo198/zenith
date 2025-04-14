package com.mystic.zenith.domain.auth.dto;

import com.mystic.zenith.domain.user.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AuthResponseDto {
    private String token;
    private UserDto user;
}
