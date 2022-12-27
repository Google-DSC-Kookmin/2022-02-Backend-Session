package com.gdsc.homework.miniCommunity.controller.user.dto.request;

import com.gdsc.homework.miniCommunity.service.user.dto.request.UserDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRequest {
    @NotNull
    private String email;
    @NotNull
    private String nickname;

    public UserDto toServiceDto(){
        return UserDto.of(email, nickname);
    }
}