package com.gdsc.homework.firstHW.Model;

import org.springframework.stereotype.Component;

@Component("pc")
public class PC implements Device {
    public String coding(){
        return "PC로 코딩하고 있어요!";
    }
}
