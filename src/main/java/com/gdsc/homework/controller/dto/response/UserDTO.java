package com.gdsc.homework.controller.dto.response;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDTO {
    private String token;
    private String email;
    private String nickName;
    private Long userId;
    public static UserDTO of(String token, String email, String nickName, Long userId){
        return new UserDTO(token, email, nickName, userId);
    }
}
