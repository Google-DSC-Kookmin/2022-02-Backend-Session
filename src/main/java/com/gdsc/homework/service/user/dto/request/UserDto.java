package com.gdsc.homework.service.user.dto.request;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDto {
    private String email;
    private String nickname;

    public static UserDto of(final String email, final String nickname) {
        return new UserDto(email, nickname);
    }
}
