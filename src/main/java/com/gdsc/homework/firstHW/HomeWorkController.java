package com.gdsc.homework.firstHW;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeWorkController {
    private final   GdscMember  gdscMember;

    public HomeWorkController(GdscMember gdscMember) {
        this.gdscMember = gdscMember;
    }

    @RequestMapping("/homework")
    public String homeWork() {
        return  gdscMember.playCoding();
    }
}