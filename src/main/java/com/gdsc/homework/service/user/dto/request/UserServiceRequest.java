package com.gdsc.homework.service.user.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserServiceRequest {
    private String email;
    private String nickname;
    private String password;

    public static UserServiceRequest newInstance(String email, String nickname, String password) {
        return new UserServiceRequest(email, nickname, password);
    }
}
