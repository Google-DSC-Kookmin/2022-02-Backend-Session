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
    private Long userId;
    private String name;
    private String description;
    public static MemberDto of(String name, Long userId, String description) {
        return new MemberDto(userId, name, description);
    }
}
