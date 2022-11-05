package com.gdsc.homework.thirdstudy.controller.backend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BackendController {

    @GetMapping("/backend")
    public String gdscBackend(){
        String backend = "GDSCBackend";
        log.info("GDSC Backend = {}",backend);
        return backend;
    }
}
