package com.oop14;

public class Hero {
    String name;
    int hp;

    Hero(String name, int hp){
        this.name = name;
        this.hp = hp;
    }

    void attack() {
        System.out.println(this.getClass().getSimpleName() + "이(가) 공격합니다.");
    }
}
