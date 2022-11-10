package com.gdsc.homework.HW3.controller;

import com.gdsc.homework.HW3.controller.dto.request.MemberRequest;
import com.gdsc.homework.HW3.controller.dto.response.MemberResponse;
import com.gdsc.homework.HW3.service.MemberService;
import com.gdsc.homework.HW3.service.dto.response.MemberServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping(value = "/signUp", consumes = "application/json")
    public MemberResponse signUp(@RequestBody MemberRequest memberRequest) {
        MemberServiceResponse response = memberService.enroll(memberRequest.toServiceDto(memberRequest));
        return MemberResponse.newInstance(response.getId(), response.getName(), response.getEmail(), response.getDescription());
    }
}
