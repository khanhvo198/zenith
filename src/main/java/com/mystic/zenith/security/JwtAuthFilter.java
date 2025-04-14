package com.mystic.zenith.security;

import com.mystic.zenith.shared.service.JwtService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JwtAuthFilter extends GenericFilter {

    private final String PREFIX_TOKEN = "Bearer ";
    private final JwtService jwtService;
    private final AuthenticationProvider authenticationProvider;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        Optional.ofNullable(((HttpServletRequest) request).getHeader(HttpHeaders.AUTHORIZATION))
                .filter(header -> header.startsWith(PREFIX_TOKEN))
                .map(header -> header.substring(PREFIX_TOKEN.length()))
                .map(jwtService::getSubject)
                .map(authenticationProvider::getAuthentication)
                .ifPresent(SecurityContextHolder.getContext()::setAuthentication);

        filterChain.doFilter(request, response);
    }
}
