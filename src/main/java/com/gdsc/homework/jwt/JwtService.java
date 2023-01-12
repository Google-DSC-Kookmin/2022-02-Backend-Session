package com.gdsc.homework.jwt;

public interface JwtService {
    String issuedToken(String subject, String role, long periodSecond);

    boolean verifyToken(String token);

    String getSubject(String token);
}