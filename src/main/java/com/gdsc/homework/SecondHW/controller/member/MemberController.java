package com.gdsc.homework.SecondHW.controller.member;

import com.gdsc.homework.SecondHW.controller.member.dto.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @GetMapping("/GDSCBackend")
    public String printGDSC(){
        log.info("GDSC Backend");
        return "ok";
    }
    @GetMapping("/mapping/users/{userId}")
    public String mappingPath(@PathVariable String userId){
        log.info("mapping Path userId={}", userId);
        return "ok";
    }
    @PostMapping(value = "/member/dto", consumes = "application/json")
    public String requestDTO (@RequestBody MemberRequest memberRequest){
        log.info("userId={}, name={}, description={}",memberRequest.getUserId(),memberRequest.getName(),memberRequest.getDescription());
        return "ok";
    }
    @GetMapping("/member")
    public String requestparam(@RequestParam String param){
        log.info("param={}", param);
        return "ok";
    }
}
