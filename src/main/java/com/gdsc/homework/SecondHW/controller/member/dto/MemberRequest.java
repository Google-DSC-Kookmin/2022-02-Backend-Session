package com.gdsc.homework.SecondHW.controller.member.dto;

import lombok.*;
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberRequest {
    private String userId;
    private String name;
    private String description;

}
