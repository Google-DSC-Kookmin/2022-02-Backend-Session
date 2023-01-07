package com.gdsc.homework.controller.user.dto.request;

import com.gdsc.homework.service.user.dto.request.UserServiceRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserRequest {
    @Email
    private String email;
    @NotNull
    @NotBlank
    private String nickname;
    @NotNull
    @NotBlank
    private String password;

    public static UserServiceRequest toServiceDto(String email, String nickname, String password) {
        return UserServiceRequest.newInstance(email, nickname, password);
    }
}
