package com.example.demojwt.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    private String SECRET_KEY = "secret";
    private int jwtExpirationMs = 1000 * 60 * 10;


    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        // How to add claims fields, usually they are passed as parameters
        //claims.put("userId", "1234User");
        return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }
}