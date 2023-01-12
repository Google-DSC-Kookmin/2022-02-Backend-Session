package com.gdsc.homework.service.dto.request;

import lombok.Getter;

@Getter
public class SignUpDto {
    private String nickname;

    private SignUpDto(String nickname) {
        this.nickname = nickname;
    }

    public static SignUpDto of(String nickname) {
        return new SignUpDto(nickname);
    }
}
