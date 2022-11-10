package com.gdsc.homework.thirdstudy.controller.member.dto.requset;


import com.gdsc.homework.thirdstudy.service.member.dto.request.MemberDto;
import lombok.*;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberBodyRequest {
    @NotNull
    private Long userId;

    @NotNull
    private String name;

    @NotNull
    private String description;


    public MemberDto toServiceDto(){
        return MemberDto.of(name);
    }
}
