package org.example.apigateway.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class JwtService {

    @Value("${jwt.secret}")
    private String token;


    public Claims parseToken(String token) {
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(token.getBytes()))
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
