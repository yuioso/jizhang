package com.demo.account.utils;

import io.jsonwebtoken.*;

import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;


import java.util.Date;



@Component
public class JwtUtil {



    private final String SECRET =
            "AIAccountSystemJwtSecretKeyForLogin2026";



    public String createToken(
            Long userId
    ){


        return Jwts.builder()

                .setSubject(
                        userId.toString()
                )

                .setIssuedAt(
                        new Date()
                )

                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        +
                                        1000*60*60*24
                        )
                )

                .signWith(
                        Keys.hmacShaKeyFor(
                                SECRET.getBytes()
                        ),
                        SignatureAlgorithm.HS256
                )

                .compact();



    }

    public Long getUserId(String token){


        Claims claims =
                Jwts.parserBuilder()

                        .setSigningKey(
                                SECRET.getBytes()
                        )

                        .build()

                        .parseClaimsJws(token)

                        .getBody();



        return Long.valueOf(
                claims.getSubject()
        );


    }


}

