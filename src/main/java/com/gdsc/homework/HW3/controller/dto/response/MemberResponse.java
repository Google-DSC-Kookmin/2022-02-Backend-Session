package com.gdsc.homework.HW3.controller.dto.response;

import lombok.*;

import java.lang.reflect.Member;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberResponse {
    Long id;
    String name;
    String email;
    String description;

    public static MemberResponse newInstance(Long id, String name, String email,String description) {
        return new MemberResponse(id,name,email,description);
    }
}
