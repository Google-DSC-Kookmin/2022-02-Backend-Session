package com.gdsc.homework.thirdstudy.service.member.dto.request;

import lombok.*;


@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberDescriptionDto {
    private Long userId;
    private String name;
    private String description;

    public static MemberDescriptionDto of(Long userId, String name, String description) {
        return new MemberDescriptionDto(userId, name, description);
    }
}
