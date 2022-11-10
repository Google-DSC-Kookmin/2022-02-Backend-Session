package com.gdsc.homework.HW3.service.dto.request;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberServiceRequest {
    private String name;
    private String userId;
    private String description;

    public static MemberServiceRequest newInstance(String name, String userId, String description) {
        return new MemberServiceRequest(name,userId,description);
    }
}
