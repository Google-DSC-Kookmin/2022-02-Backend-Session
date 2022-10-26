package com.gdsc.homework.firstHW.Model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GdscMember {
    private final Device device;

    public GdscMember(@Qualifier("laptop") Device device) {
        this.device = device;
    }

    public Device getDevice() {
        return device;
    }

    public String playCoding(){
//        System.out.println("서버 파트원이 코딩을 하고 있어요!");
        this.device.coding();
        return "서버 파트원이 코딩을 하고 있어요! " + this.device.coding();
    }
}
