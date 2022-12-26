package com.gdsc.homework.firstAssignment.service.user.dto;

import com.gdsc.homework.firstAssignment.domain.user.User;
import lombok.Getter;

@Getter
public class UserRegisterResDto {
    private String email;
    private String nickname;

    public static UserRegisterResDto of(User user) {
        return new UserRegisterResDto(user);
    }

    private UserRegisterResDto(User user) {
        this.email = user.getEmail();
        this.nickname = user.getNickname();
    }
}
