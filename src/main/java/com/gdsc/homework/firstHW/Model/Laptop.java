package com.gdsc.homework.firstHW.Model;

import org.springframework.stereotype.Component;

@Component("laptop")
public class Laptop implements Device {
    public String coding(){
        return "노트북으로 코딩하고 있어요!";
    }
}
