package com.gdsc.homework.thirdstudy.controller.member;

import com.gdsc.homework.thirdstudy.controller.member.dto.requset.MemberRequest;
import com.gdsc.homework.thirdstudy.service.member.MemberService;
import com.gdsc.homework.thirdstudy.service.member.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class MemberController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final MemberService memberService;

    @GetMapping("/homework2")
    public String gdscLog() {
        String gdscBackend = "GDSCBackend";
        log.info("GDSC Backend = {}", gdscBackend);
        return "ok";
    }

    @GetMapping("/homework2/users/{userId}")
    public String getUserId(@PathVariable int userId) {
        log.info("userId = {}", userId);
        return "ok";
    }

    @PostMapping("/homework2/user")
    public MemberRequest requestBody(@RequestBody final MemberRequest memberRequest){
        log.info("request = {}", memberRequest.toString());
        return memberRequest;
    }

    @GetMapping("/homework2/search")
    public String searchParam(@RequestParam String search) {
        log.info("search = {}", search);
        return "ok";
    }

    @GetMapping("/request-param")
    public String requestParam(@RequestParam final String username, @RequestParam final int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable final String userId, @PathVariable final String orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    @PostMapping(value = "/member/new", consumes = "application/json")
//    @RequestMapping(value = "/member/new", method = RequestMethod.POST)
    public void saveMember(@Valid @RequestBody final MemberRequest request){
        memberService.signUp(request.toServiceDto());
    }
    @GetMapping("/member/{userId}")
    public MemberResponse getMember(@PathVariable final Long userId){
        return memberService.getMember(userId);
    }

    @GetMapping("/member")
    public MemberResponse getMemberByName(@RequestParam(required = true) final String name){
        return memberService.getMemberByName(name);
    }
}
