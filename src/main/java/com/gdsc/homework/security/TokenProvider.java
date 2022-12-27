package com.gdsc.homework.security;

import com.gdsc.homework.service.dto.response.UserResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class TokenProvider {
    private static final String SECRET_KEY = "Mlksajd12049847ajdafdjhaldksjfljkas1214jasdlkfja;lkdsf;jaslkfhdflajsd";
    public String createToken(UserResponse userResponse){
        Date expTime = Date.from(Instant.now().plus(1, ChronoUnit.DAYS));
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] secreteKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(secreteKeyBytes, signatureAlgorithm.getJcaName());
        return Jwts.builder().setSubject(userResponse.getEmail())
                .signWith(signingKey, signatureAlgorithm)
                .setExpiration(expTime)
                .compact();
//        return Jwts.builder()
//                .signWith(SignatureAlgorithm.HS512,SECRET_KEY)
//                .setSubject(userResponse.getEmail())
//                .setIssuedAt(new Date())
//                .setExpiration(expireDate)
//                .compact();
    }
//    public String validateAndGetUserId(String token) {
////        Claims claims =Jwts.parser()
////                .setSigningKey(SECRET_KEY)
////                .parseClaimsJwt(token)
////                .getBody();
////        return claims.getSubject();
////    }
//        Claims claims = Jwts.parserBuilder()
//                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
//                .build()
//                .parseClaimsJwt(token)
//                .getBody();
//        return claims.getSubject();
//    }
}
