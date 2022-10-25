package com.gdsc.homework.firstHW.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GdscMember {
    private final Tool tool;

    public GdscMember(@Qualifier("labtop") Tool tool) {
        this.tool = tool;
    }

    public void playCoding(){
        System.out.println("서버 파트원이 코딩을 하고 있어요!");
        this.tool.coding();
    }
}
