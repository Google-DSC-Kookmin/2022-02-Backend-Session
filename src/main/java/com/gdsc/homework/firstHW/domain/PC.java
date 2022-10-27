package com.gdsc.homework.firstHW.domain;

import org.springframework.stereotype.Component;

@Component("PC")
public class PC implements CodingMachine{
    @Override
    public void coding(){
        System.out.println("PC로 코딩하고 있어요!");
    }
}
