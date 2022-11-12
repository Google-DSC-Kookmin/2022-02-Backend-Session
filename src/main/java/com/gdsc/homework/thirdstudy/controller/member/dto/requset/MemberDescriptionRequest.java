package com.gdsc.homework.thirdstudy.controller.member.dto.requset;


import com.gdsc.homework.thirdstudy.service.member.dto.request.MemberDescriptionDto;
import com.gdsc.homework.thirdstudy.service.member.dto.request.MemberDto;
import lombok.*;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberDescriptionRequest {

    @NotNull
    private Long userId;
    @NotNull
    private String name;

    private String description;

    public MemberDescriptionDto toServiceDto(){
        return MemberDescriptionDto.of(userId, name, description);
    }
}
