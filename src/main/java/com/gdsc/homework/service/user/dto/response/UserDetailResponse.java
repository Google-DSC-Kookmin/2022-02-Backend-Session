package com.gdsc.homework.service.user.dto.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@ToString
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDetailResponse {
    private Long userId;
    private String email;
    private String nickname;

    public static UserDetailResponse of(final Long userId, final String email, final String nickname) {
        return new UserDetailResponse(userId, email, nickname);
    }
}
