package com.gdsc.homework.firstHW.controller;

import com.gdsc.homework.firstHW.domain.GdscMember;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GdscMemberController {
    private final GdscMember gdscMember;

    public GdscMemberController(GdscMember gm) {
        gdscMember = gm;
    }

    @RequestMapping("/gdsc-member")
    public void playCoding() {
        this.gdscMember.playCoding();
    }
}
