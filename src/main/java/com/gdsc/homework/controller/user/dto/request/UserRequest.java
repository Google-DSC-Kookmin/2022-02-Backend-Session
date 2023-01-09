package com.gdsc.homework.controller.user.dto.request;

import com.gdsc.homework.service.user.dto.request.UserDto;
import lombok.*;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String nickname;

    public UserDto toServiceDto() {
        return UserDto.of(email, nickname);
    }
}
