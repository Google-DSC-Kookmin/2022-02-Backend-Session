package com.gdsc.homework.HW3.controller.dto.request;

import com.gdsc.homework.HW3.service.dto.request.MemberServiceRequest;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE) // 빈 생성자가 없으면 에러나는 듯
@AllArgsConstructor
public class MemberRequest {
    String name;
    String userId;
    String description;

    public static MemberServiceRequest toServiceDto(MemberRequest memberRequest) {
        return MemberServiceRequest.newInstance(memberRequest.name, memberRequest.userId, memberRequest.description);
    }
}
