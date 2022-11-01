package com.gdsc.homework.thirdstudy.service.member.dto.response;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberResponse {
    private Long userId;
    private String name;

    public static MemberResponse of(Long id, String name) {
        return new MemberResponse(id, name);
    }
}
