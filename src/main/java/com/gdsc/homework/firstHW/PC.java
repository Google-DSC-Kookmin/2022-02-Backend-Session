package com.gdsc.homework.firstHW;

import org.springframework.stereotype.Component;

@Component("PC")
class PC implements Computer {
    @Override
    public String Coding() {
        return "PC로 코딩하고 있어요!";
    }
}
