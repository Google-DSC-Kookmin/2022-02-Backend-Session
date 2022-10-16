package com.gdsc.homework.firstHW.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GdscMember {
    private Computer computer;

    public GdscMember(@Qualifier("laptop") Computer computer) {
        this.computer = computer;
    }

    public String playCoding(){
        String result = "서버 파트원이 코딩을 하고 있어요!\n" +
        this.computer.coding();

        return result;
    }
}
