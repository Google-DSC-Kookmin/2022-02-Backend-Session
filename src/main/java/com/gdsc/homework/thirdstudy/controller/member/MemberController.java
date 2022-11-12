package com.gdsc.homework.thirdstudy.controller.member;

import com.gdsc.homework.thirdstudy.controller.member.dto.requset.MemberDescriptionRequest;
import com.gdsc.homework.thirdstudy.controller.member.dto.requset.MemberRequest;
import com.gdsc.homework.thirdstudy.service.member.MemberService;
import com.gdsc.homework.thirdstudy.service.member.dto.request.MemberDescriptionDto;
import com.gdsc.homework.thirdstudy.service.member.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @GetMapping("/log")
    public String logging() {
        log.info("GDSC Backend");
        return "ok";
    }

    @PostMapping("/log")
    public MemberDescriptionRequest loggingDescription(@RequestBody MemberDescriptionRequest memberData) {
        log.info("memberData = {}", memberData.toString());
        return memberData;
    }

    @GetMapping("/log/{userId}")
    public String loggingUserId(@PathVariable String userId) {
        log.info("loggingUserId userId={}", userId);
        return "ok";
    }

    @GetMapping("/log-search")
    public String loggingSearch(@RequestParam String search) {
        log.info("loggingSearch search={}", search);
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
        return memberService.getMember(userId);
    }

    @GetMapping("/member")
    public MemberResponse getMemberByName(@RequestParam(required = true) String name){
        return memberService.getMemberByName(name);
    }
}
