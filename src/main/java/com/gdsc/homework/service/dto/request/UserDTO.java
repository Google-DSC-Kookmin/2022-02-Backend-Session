package com.gdsc.homework.service.dto.request;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDTO {
    private String nickname;
    private String email;
    private String password;

    public static UserDTO of(String nickname, String email, String password){
        return new UserDTO(nickname, email, password);
    }
}
