package com.gdsc.homework.HW5.service.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserServiceResponse {
    Long id;
    String name;
    String email;
    String password;

    public static UserServiceResponse of(Long id, String name, String email, String password) {
        return new UserServiceResponse(id,name,email,password);
    }
}

