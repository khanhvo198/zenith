package com.mystic.zenith.domain.auth.service;

import com.mystic.zenith.domain.auth.entity.AuthUserDetails;
import com.mystic.zenith.domain.user.entity.UserEntity;
import com.mystic.zenith.domain.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@AllArgsConstructor
@Service
public class AuthUserDetailServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = userRepository.findByEmail(username);

        return userEntity
                .map(user -> AuthUserDetails
                        .builder()
                        .email(user.getEmail())
                        .username(user.getUsername())
                        .id(user.getId())
                        .build())
                .orElse(null);
    }
}
