package com.gdsc.homework.controller.user.dto.request;

import com.gdsc.homework.service.user.dto.request.UserInfoServiceRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChangeUserInfoRequest {
    @Email
    private String email;

    @NotBlank
    private String nickname;

    public static UserInfoServiceRequest toServiceDto(String originalEmail, String modifyEmail, String nickname) {
        return UserInfoServiceRequest.newInstance(originalEmail, modifyEmail,nickname);
    }
}
