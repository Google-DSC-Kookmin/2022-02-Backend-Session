package com.gdsc.homework.firstHW.model;

import org.springframework.stereotype.Component;

@Component("pc")
public class PC implements Tool {
    @Override
    public void coding(){
        System.out.println("PC로 코딩하고 있어요!");
    }
}
