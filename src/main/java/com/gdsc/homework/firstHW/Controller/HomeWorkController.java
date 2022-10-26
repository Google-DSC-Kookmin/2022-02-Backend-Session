package com.gdsc.homework.firstHW.Controller;

import com.gdsc.homework.firstHW.Model.GdscMember;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeWorkController {
    private final GdscMember gdscMember;

    public HomeWorkController(GdscMember gdscMember) {
        this.gdscMember = gdscMember;
    }

    @RequestMapping("/coding")
    public String coding() {
        return this.gdscMember.playCoding();
    }

}
