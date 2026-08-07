package com.oop14;

public class Archer extends Hero {

    public Archer(String name, int hp) {
        super(name, hp);
    }

    void fireArrow() {
        System.out.println(this.getClass().getSimpleName() + "이(가) 불화살공격합니다.");
    }

}
