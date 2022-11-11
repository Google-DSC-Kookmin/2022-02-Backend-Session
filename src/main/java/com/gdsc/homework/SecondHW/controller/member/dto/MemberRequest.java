package com.gdsc.homework.SecondHW.controller.member.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberRequest {
    @NotNull
    private String userId;
    @NotNull
    private String name;
    private String description;

}
