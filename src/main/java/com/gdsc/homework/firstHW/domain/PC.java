package com.gdsc.homework.firstHW.domain;

import org.springframework.stereotype.Component;

@Component("PC")
public class PC implements Computer{
    @Override
    public String coding(){
        return "PC로 코딩하고 있어요!";
    }
}
