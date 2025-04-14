package com.mystic.zenith.domain.user.dto.response;

import com.mystic.zenith.domain.user.dto.UserDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserResponseDto {
    UserDto user;
}
