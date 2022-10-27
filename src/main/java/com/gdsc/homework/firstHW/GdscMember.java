package com.gdsc.homework.firstHW;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GdscMember {
    private final Computer computer;

    public GdscMember(@Qualifier("Laptop") Computer computer) {
        this.computer = computer;
    }

    public String playCoding() {
        return("서버 파트원이 코딩을 하고 있어요!<br>" + this.computer.Coding());
    }
}
