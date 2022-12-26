package com.gdsc.homework.controller.user.dto.request;

import com.gdsc.homework.service.user.dto.request.UserServiceRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserRequest {
    private String email;
    private String nickname;
    private String password;

    public static UserServiceRequest toServiceDto(String email, String nickname, String password) {
        return UserServiceRequest.newInstance(email, nickname, password);
    }
}
