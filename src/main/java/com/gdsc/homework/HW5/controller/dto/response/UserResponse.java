package com.gdsc.homework.HW5.controller.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private String password;

    public static UserResponse newInstance(Long id, String name, String email, String password) {
        return new UserResponse(id, name, email, password);
    }
}
