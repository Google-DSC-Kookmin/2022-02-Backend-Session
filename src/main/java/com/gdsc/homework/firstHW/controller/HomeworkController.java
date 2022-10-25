package com.gdsc.homework.firstHW.controller;

import com.gdsc.homework.firstHW.model.GdscMember;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeworkController {
    private final GdscMember gdscMember;

    public HomeworkController(GdscMember gdscMember){
        this.gdscMember = gdscMember;
    }

    @RequestMapping("/playCoding")
    public void playCoding(){
        gdscMember.playCoding();
    }

}
