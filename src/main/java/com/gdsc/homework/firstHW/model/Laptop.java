package com.gdsc.homework.firstHW.model;

import org.springframework.stereotype.Component;

@Component("labtop")
public class Laptop implements Tool {
   @Override
    public void coding(){
        System.out.println("노트북으로 코딩하고 있어요!");
    }
}
