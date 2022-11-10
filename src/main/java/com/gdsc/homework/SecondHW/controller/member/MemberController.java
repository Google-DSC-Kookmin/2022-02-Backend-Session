package com.gdsc.homework.SecondHW.controller.member;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
