package com.oop14;

public class Wizard extends Hero {

    public Wizard(String name, int hp) {
        super(name, hp);
    }

    void freezing() {
        System.out.println(this.getClass().getSimpleName() + "이(가) 얼음마법합니다.");
    }
}
