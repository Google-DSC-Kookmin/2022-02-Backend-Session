package com.gdsc.homework.firstHW.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("GdscMember")
public class GdscMember {
    private final CodingMachine codingMachine;

    public GdscMember(@Qualifier("laptop") CodingMachine cm) {
        codingMachine = cm;
    }

    public void playCoding(){
        System.out.println("서버 파트원이 코딩을 하고 있어요!");
        this.codingMachine.coding();
    }
}
