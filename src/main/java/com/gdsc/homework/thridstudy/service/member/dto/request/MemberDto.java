package com.gdsc.homework.thridstudy.service.member.dto.request;

import lombok.*;


@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberDto {
    private String name;

    public static MemberDto of(String name) {
        return new MemberDto(name);
    }
}
