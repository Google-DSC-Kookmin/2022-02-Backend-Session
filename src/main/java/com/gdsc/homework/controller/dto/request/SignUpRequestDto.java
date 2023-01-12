package com.gdsc.homework.controller.dto.request;

import com.gdsc.homework.service.dto.request.SignUpDto;
import lombok.Getter;

@Getter
public class SignUpRequestDto {

    private String nickname;

    public SignUpDto toServiceDto() {
        return SignUpDto.of(nickname);
    }
}
