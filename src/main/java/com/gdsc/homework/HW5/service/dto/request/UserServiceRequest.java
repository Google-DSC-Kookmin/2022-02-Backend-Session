package com.gdsc.homework.HW5.service.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserServiceRequest {
    private String name;
    private String email;
    private String password;

    public static UserServiceRequest newInstance(String name, String email, String password){
        return new UserServiceRequest(name,email,password);
    }
}
