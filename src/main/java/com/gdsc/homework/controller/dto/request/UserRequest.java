package com.gdsc.homework.controller.dto.request;

import com.gdsc.homework.service.dto.request.UserDTO;
import lombok.*;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRequest {
    @NotNull
    private String nickname;
    @NotNull
    private String email;
    @NotNull
    private String password;

    public UserDTO toServiceDto(){
        return UserDTO.of(nickname, email, password);
    }


}
