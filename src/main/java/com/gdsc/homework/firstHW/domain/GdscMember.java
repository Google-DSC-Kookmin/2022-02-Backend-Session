package com.gdsc.homework.firstHW.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GdscMember {
    private final Computer computer;

    public GdscMember(@Qualifier("laptop") Computer computer) {
        this.computer = computer;
    }

    public void playCoding() {
        System.out.println("서버 파트원이 코딩을 하고 있어요!");
    }
}
