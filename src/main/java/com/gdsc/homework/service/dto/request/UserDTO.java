package com.gdsc.homework.service.dto.request;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDTO {
    private Long userId;
    private String nickname;
    private String email;
    private String password;

    public UserDTO(Long userId, String nickname, String email) {
        this.userId = userId;
        this.nickname = nickname;
        this.email = email;
    }

    public UserDTO(String nickname, String email, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public static UserDTO of(String nickname, String email, String password){
        return new UserDTO(nickname, email, password);
    }
    public static UserDTO of(Long userId, String nickname, String email){
        return new UserDTO(userId,nickname, email);
    }
}
