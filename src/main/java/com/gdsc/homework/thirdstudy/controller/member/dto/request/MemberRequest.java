package com.gdsc.homework.thirdstudy.controller.member.dto.request;


import com.gdsc.homework.thirdstudy.service.member.dto.request.MemberDto;
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
public class MemberRequest {

    @NotNull
    private String name;

    private String description;

    public MemberDto toServiceDto(){
        return MemberDto.of(name, description);
    }
}
