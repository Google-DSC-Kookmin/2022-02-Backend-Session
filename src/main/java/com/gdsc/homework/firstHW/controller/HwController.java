package com.gdsc.homework.firstHW.controller;

import com.gdsc.homework.firstHW.model.GdscMember;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HwController {
    private final GdscMember gdscMember;

    public HwController(GdscMember gdscMember){

        this.gdscMember = gdscMember;

    }

    @RequestMapping("/homework")
    public String doHomework(){

        return gdscMember.playCoding();

    }
}
