package com.mystic.zenith.domain.auth.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RegisterRequestDto {
    private String email;
    private String password;
    private String username;
}
