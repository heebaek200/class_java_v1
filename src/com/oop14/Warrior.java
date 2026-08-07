package com.oop14;

public class Warrior extends Hero {

    Warrior(String name, int hp) {
        super(name, hp);
    }

    void comboAttack() {
        System.out.println(this.getClass().getSimpleName() + "이(가) 컴보공격합니다.");
    }

}
