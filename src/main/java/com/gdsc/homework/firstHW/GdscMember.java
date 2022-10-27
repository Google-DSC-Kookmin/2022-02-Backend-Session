package com.gdsc.homework.firstHW;

import com.gdsc.homework.firstHW.domain.Computer;
import com.gdsc.homework.firstHW.domain.Laptop;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GdscMember {
    private final Computer computer;

    public GdscMember(@Qualifier("LapTop") Computer computer){
        this.computer = computer;
    }

    public String playCoding(){
        String result = ("서버 파트원이 코딩을 하고 있어요!");
        String coding = this.computer.coding();
        return result + "\n" + coding;
    }
}
