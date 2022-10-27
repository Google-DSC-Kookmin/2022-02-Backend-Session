package com.gdsc.homework.firstHW.controller;


import com.gdsc.homework.firstHW.GdscMember;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeWorkController {
    private final GdscMember gdscMember;

    @GetMapping("/homework")
    public String homework(){
        return gdscMember.playCoding();
    }
}
