package com.gdsc.homework.miniCommunity.service.user.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AccessLevel;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponse {
    private Long userId;
    private String email;
    private String nickname;

    public static UserResponse of(Long id, String email, String nickname) {
        return new UserResponse(id, email, nickname);
    }
}
