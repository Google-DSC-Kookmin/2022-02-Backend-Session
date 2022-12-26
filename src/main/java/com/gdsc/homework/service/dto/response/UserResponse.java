package com.gdsc.homework.service.dto.response;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponse {
    private Long userId;
    private String nickName;
    private String email;
    private String password;

    public UserResponse(Long userId, String nickName, String email) {
        this.userId = userId;
        this.nickName = nickName;
        this.email = email;
    }

    public static UserResponse of(Long id, String nickName, String email){
        return new UserResponse(id, nickName, email);
    }
}
