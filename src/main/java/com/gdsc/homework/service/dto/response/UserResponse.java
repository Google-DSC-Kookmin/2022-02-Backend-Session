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

    public static UserResponse of(Long id, String nickName, String email, String password){
        return new UserResponse(id, nickName, email, password);
    }
}
