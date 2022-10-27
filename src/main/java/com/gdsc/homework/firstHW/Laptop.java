package com.gdsc.homework.firstHW;

import org.springframework.stereotype.Component;

@Component("Laptop")
class Laptop implements Computer {
    @Override
    public String Coding() {
        return "노트북으로 코딩하고 있어요!";
    }
}
