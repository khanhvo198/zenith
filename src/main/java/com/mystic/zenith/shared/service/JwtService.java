package com.mystic.zenith.shared.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.util.Date;

@Service
public class JwtService {

    @Value("${zenith.auth.token.secret-key}")
    private String SECRET_KEY;

    @Value("${zenith.auth.token.expiration}")
    private Long EXPIRATION;

    public String getSubject(String token) {
        return Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload().getSubject();
    }

    public boolean isTokenValid(String token) {
        Date expiration = Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token).getPayload().getExpiration();
        return expiration.after(Date.from(Instant.now()));
    };


    private SecretKey getSigningKey() {
        return (SecretKey) Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public String encode(String email) {
        return Jwts.builder().subject(email).signWith(getSigningKey()).compact();
    }


}
