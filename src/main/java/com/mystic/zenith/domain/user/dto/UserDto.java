package com.mystic.zenith.domain.user.dto;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private UUID id;
    private String email;
    private String username;
    private String bio;
    private String avatar_url;
}
