package com.gdsc.homework.HW5.controller.user.dto.request;

import com.gdsc.homework.HW5.service.user.dto.request.UserServiceRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserRequest {
    String name;
    String email;
    String password;

    public static UserServiceRequest toServiceDto(String name, String email, String password) {
        return UserServiceRequest.newInstance(name, email, password);
    }
}
