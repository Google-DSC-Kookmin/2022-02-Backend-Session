package com.gdsc.homework.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JwtTokenProvider {
    private final String secretKey = "testkey";
    private final Long tokenValidTime = 30 * 60 * 1000L; // 토큰 유효기간(30분)
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    public String createJwt(String userEmail) {
        Claims claims = Jwts.claims().setSubject(userEmail);

        Date now = new Date();
        String jwt = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidTime))
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();
        return jwt;
    }

    public Map<String, Object> validateJwt (String jwt) throws IllegalArgumentException {
        Map<String, Object> claimMap = null;
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey.getBytes())
                    .parseClaimsJws(jwt)
                    .getBody();

            claimMap = claims;
        } catch (ExpiredJwtException e) {
            logger.info("유효기간 만료 {}", e);
            throw new IllegalArgumentException();
        } catch (Exception e) {
            logger.info("기타 예외 {}",e);
            throw new IllegalArgumentException();
        }
        return claimMap;
    }

    public static JwtTokenProvider newInstance() {
        return new JwtTokenProvider();
    }
}
