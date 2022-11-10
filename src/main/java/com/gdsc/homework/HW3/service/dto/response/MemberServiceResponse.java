package com.gdsc.homework.HW3.service.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberServiceResponse {
    Long id;
    String name;
    String email;
    String description;

    public static MemberServiceResponse of(Long id, String name, String email, String description) {
        return new MemberServiceResponse(id,name,email, description);
    }
}
