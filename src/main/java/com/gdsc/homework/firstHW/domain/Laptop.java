package com.gdsc.homework.firstHW.domain;

import org.springframework.stereotype.Component;

@Component("LapTop")
public class Laptop implements Computer{
    @Override
    public void coding(){
        System.out.println("노트북으로 코딩하고 있어요!");
    }
}
