package com.oop14;

public class HeroTest {

    public static void main(String[] args) {
        Hero hero = new Hero("김영웅", 100);
        Warrior warrior = new Warrior("이전사", 200);
        Archer archer = new Archer("최궁수", 80);
        Wizard wizard = new Wizard("박법사", 70);

        hero.attack();
        warrior.attack();
        warrior.comboAttack();
        archer.attack();
        archer.fireArrow();
        wizard.attack();
        wizard.freezing();
    }

}
