package com.gdsc.homework.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    private Key key = Keys.hmacShaKeyFor(Secret.JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    public String createJwt(Long userId) {
        Date now = new Date();
        return Jwts.builder()
                .setHeaderParam("type","jwt")
                .claim("userId", userId)
                .setIssuedAt(now)
                .setExpiration(new Date(System.currentTimeMillis()+1*(1000*60*60*24*365)))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public String getJwt() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes())
                .getRequest();
        return request.getHeader("authorization");
    }

    public Long getUserId() throws IllegalArgumentException{
        //1. JWT 추출
        String accessToken = getJwt();
        if(accessToken == null || accessToken.length() == 0){
            throw new IllegalArgumentException("EMPTY_JWT");
        }

        // 2. JWT parsing
        Jws<Claims> claims;
        try{
            claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(accessToken);
        } catch (Exception e) {
            throw new IllegalArgumentException("INVALID_JWT");
        }

        // 3. userIdx 추출
        return claims.getBody().get("userId", Long.class);

    }
}

