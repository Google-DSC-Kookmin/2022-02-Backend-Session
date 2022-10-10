package com.gdsc.homework.firstHW;

public class GdscMember {
    private Laptop laptop;

    public GdscMember() {
        this.laptop = new Laptop();
    }

    public void playCoding(){
        System.out.println("서버 파트원이 코딩을 하고 있어요!");
        this.laptop.coding();
    }
}
