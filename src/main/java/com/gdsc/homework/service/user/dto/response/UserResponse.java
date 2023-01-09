package com.gdsc.homework.service.user.dto.response;

import lombok.*;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponse {
    private Long userId;
    private String jwt;

    public static UserResponse of(final Long userId, final String jwt) {
        return new UserResponse(userId, jwt);
    }
}
