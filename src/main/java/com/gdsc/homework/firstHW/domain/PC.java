package com.gdsc.homework.firstHW.domain;

import org.springframework.stereotype.Component;

@Component("pc")
public class PC implements Computer {
    public String coding(){
        return "PC로 코딩하고 있어요!";
    }
}
