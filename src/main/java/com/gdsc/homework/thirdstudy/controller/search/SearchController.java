package com.gdsc.homework.thirdstudy.controller.search;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SearchController {

    @GetMapping("/search-param")
    public String searchParam(@RequestParam String search) {
        log.info("search={}",search);
        return "ok";
    }
}
