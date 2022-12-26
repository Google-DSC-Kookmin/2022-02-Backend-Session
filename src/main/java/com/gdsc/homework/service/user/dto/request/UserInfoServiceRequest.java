package com.gdsc.homework.service.user.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserInfoServiceRequest {
    private String email;
    private String nickname;

    public static UserInfoServiceRequest newInstance(String email, String nickname) {
        return new UserInfoServiceRequest(email, nickname);
    }
}
