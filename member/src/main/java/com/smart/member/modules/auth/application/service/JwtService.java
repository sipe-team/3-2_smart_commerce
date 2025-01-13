package com.smart.member.modules.auth.application.service;

import com.smart.member.modules.auth.application.SignTokenCreateUseCase;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtService implements SignTokenCreateUseCase {

    private static final String TYP = "typ";
    private static final String JWT = "JWT";
    private static final String SECRET_KEY = UUID.randomUUID().toString();

    @Override
    public String create(final Long id) {
        final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .setHeaderParam(TYP, JWT)
                .setClaims(Jwts.claims().setSubject(id.toString()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
