package com.gdsc.homework.controller.user.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponse {
    private Long id;
    private String email;
    private String nickname;

    public static UserResponse newInstance(Long id, String email, String nickname) {
        return new UserResponse(id, email, nickname);
    }
}
