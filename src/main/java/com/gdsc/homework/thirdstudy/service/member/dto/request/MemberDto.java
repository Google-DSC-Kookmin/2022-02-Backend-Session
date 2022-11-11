package com.gdsc.homework.thirdstudy.service.member.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


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
