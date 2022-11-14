package com.gdsc.homework.firstHW;

import com.gdsc.homework.firstHW.domain.PC;

public class GdscMember {
    private PC pc;

    public GdscMember() {
        this.pc = new PC();
    }

    public void playCoding(){
        System.out.println("서버 파트원이 코딩을 하고 있어요!");
        this.pc.coding();
    }
}
