package com.gdsc.homework.HW3.controller;

import com.gdsc.homework.HW3.controller.dto.request.MemberRequest;
import com.gdsc.homework.HW3.controller.dto.response.MemberResponse;
import com.gdsc.homework.HW3.service.MemberService;
import com.gdsc.homework.HW3.service.dto.response.MemberServiceResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MemberController {
    // 로거 추가
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final MemberService memberService;

    // 단순히 로그 찍는 기능
    @GetMapping("/log")
    public final String log() {
        logger.info("GDSC Backend");
        return "LOG SUCCESS!";
    }
    // request param을 이용하여 로그 찍기
    @GetMapping("/log/{userId}")
    public final String userIdLog(@PathVariable String userId) {
        logger.info("USER ID: {}", userId);
        return "LOG SUCCESS!";
    }

    // requestBody를 통해 signUp +memberRequest log 추가
    @PostMapping(value = "/signUp", consumes = "application/json")
    public final MemberResponse signUp(@RequestBody MemberRequest memberRequest) {
        logger.info(memberRequest.toString());
        MemberServiceResponse response = memberService.enroll(memberRequest.toServiceDto(memberRequest));
        return MemberResponse.newInstance(response.getId(), response.getName(), response.getUserId(), response.getDescription());
    }

    @GetMapping("/search")
    public final MemberResponse search(@RequestParam String userId) {
        logger.info("USER ID: {}", userId);
        MemberServiceResponse response = memberService.search(userId);
        logger.info("Search Success {}", response.toString());
        return MemberResponse.newInstance(
                    response.getId(),
                    response.getName(),
                    response.getUserId(),
                    response.getDescription());
    }
}
