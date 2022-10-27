package com.gdsc.homework.firstHW.domain;

import org.springframework.stereotype.Component;
@Component("laptop")
public class Laptop implements CodingMachine{
    @Override
    public void coding(){
        System.out.println("노트북으로 코딩하고 있어요!");
    }
}
