package com.mystic.zenith.domain.auth.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LoginRequestDto {
    private String email;
    private String password;
}
