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

    // 1. GDSC Backend 로그 출력
    @GetMapping("/log")
    public String log(){
        log.info("GDSC Backend");
        return "ok";
    }

    // 2. path variable 을 이용해 userId 로그 출력
    @GetMapping("/log/{userId}")
    public String logByUserId(@PathVariable String userId){
        log.info("input userId : {}", userId );
        return "ok";
    }

    // 3. DTO를 통해 받은 request를 log로 출력하기
    @PostMapping("/log")
    public String logByDto(@Valid @RequestBody MemberRequest request){
        log.info("DTO INFO / userId : {}, name : {}, description : {}",request.getUserId(),request.getName(),request.getDescription());
        return "ok";
    }

    // 4. RequestParam을 이용해 search 키워드로 받아온 값 log에 출력하기
    @GetMapping("/log-search")
    public String logBySearch(@RequestParam String search) {
        log.info("LOG BY SEARCH / search : {}", search);
        return "ok";
    }

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
}
