package com.gdsc.homework.thirdstudy.controller.member;

import com.gdsc.homework.thirdstudy.controller.member.dto.requset.MemberRequest;
import com.gdsc.homework.thirdstudy.service.member.MemberService;
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


    // 1. log를 통해서 String인 "GDSC Backend"를 출력
    @GetMapping("/log")
    public String log() {
        log.info("GDSC Backend");
        return "ok";
    }

    // 2. userId를 받아서 이를 log로 출력
    @GetMapping("/log/{userId}")
    public String logByuserId(@PathVariable String userId) {
        log.info("logByuserId userId={}", userId);
        return "ok";
    }

    // 3. DTO를 통해 userId, name, description을 request로 받고 body를 log를 이용해서 출력
    @PostMapping("/log/request")
    public String logByRequest(@RequestBody MemberRequest request) {
        log.info("logByRequest request={}", request.toString());
        return "ok";
    }

    // 4. search라는 파라미터를 받아서 이를 log로 출력
    @GetMapping("/log/search")
    public String logBySearch(@RequestParam String search) {
        log.info("logBySearch search={}", search);
        return "ok";
    }
}
