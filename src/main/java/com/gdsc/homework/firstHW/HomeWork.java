package com.gdsc.homework.firstHW;

import com.gdsc.homework.firstHW.domain.Laptop;

public class HomeWork {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        GdscMember gdscMember = new GdscMember(laptop);
        gdscMember.playCoding();
    }
}
