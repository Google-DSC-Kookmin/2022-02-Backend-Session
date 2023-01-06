package com.gdsc.homework.controller.user.dto.request;

import com.gdsc.homework.service.user.dto.request.UserInfoServiceRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChangeUserInfoRequest {
    private String email;
    private String nickname;

    public static UserInfoServiceRequest toServiceDto(String originalEmail, String modifyEmail, String nickname) {
        return UserInfoServiceRequest.newInstance(originalEmail, modifyEmail,nickname);
    }
}
