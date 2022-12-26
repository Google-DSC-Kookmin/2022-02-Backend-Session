package com.gdsc.homework.service.user.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserServiceResponse {
    private Long id;
    private String email;
    private String nickname;

    public static UserServiceResponse of(Long id, String email, String nickname) {
        return new UserServiceResponse(id, email, nickname);
    }
}
