package com.gdsc.homework.thridstudy.controller.member.dto.requset;


import com.gdsc.homework.thridstudy.service.member.dto.request.MemberDto;
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

    public MemberDto toServiceDto(){
        return MemberDto.of(name);
    }
}
