package com.gdsc.homework.HW3.controller;

import com.gdsc.homework.HW3.controller.dto.request.MemberRequest;
import com.gdsc.homework.HW3.controller.dto.response.MemberResponse;
import com.gdsc.homework.HW3.service.MemberService;
import com.gdsc.homework.HW3.service.dto.response.MemberServiceResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {
    // 로거 추가
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final MemberService memberService;

    @GetMapping("/log")
    public void log() {
        logger.info("GDSC Backend");
    }

    @GetMapping("/log/{id}")


    @PostMapping(value = "/signUp", consumes = "application/json")
    public MemberResponse signUp(@RequestBody MemberRequest memberRequest) {
        MemberServiceResponse response = memberService.enroll(memberRequest.toServiceDto(memberRequest));
        return MemberResponse.newInstance(response.getId(), response.getName(), response.getUserId(), response.getDescription());
    }
}
