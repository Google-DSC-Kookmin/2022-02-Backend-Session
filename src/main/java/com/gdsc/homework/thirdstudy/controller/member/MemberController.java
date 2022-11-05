package com.gdsc.homework.thirdstudy.controller.member;

import com.gdsc.homework.thirdstudy.controller.member.dto.requset.MemberBodyRequest;
import com.gdsc.homework.thirdstudy.controller.member.dto.requset.MemberRequest;
import com.gdsc.homework.thirdstudy.service.member.MemberService;
import com.gdsc.homework.thirdstudy.service.member.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/request-body")
    public MemberRequest requestBody(@RequestBody MemberRequest helloData){
        log.info("helloDate = {}", helloData.toString());
        return helloData;
    }

    @GetMapping("/request-param")
    public String requestParam(@RequestParam String username, @RequestParam int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable String orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }



    @PostMapping(value = "/member/new", consumes = "application/json")
//    @RequestMapping(value = "/member/new", method = RequestMethod.POST)
    public void saveMember(@Valid @RequestBody final MemberRequest request){
        memberService.signUp(request.toServiceDto());
    }

    @GetMapping("/member/{userId}")
    public MemberResponse getMember(@PathVariable Long userId){
        log.info("userId = {}",userId);
        return memberService.getMember(userId);
    }

    @GetMapping("/member")
    public MemberResponse getMemberByName(@RequestParam(required = true) String name){
        return memberService.getMemberByName(name);
    }

    @PostMapping(value = "/requestbody", consumes = "application/json")
    public void logBody(@RequestBody MemberBodyRequest memberBodyRequest){
        log.info("request = {}", memberBodyRequest);
    }



}
