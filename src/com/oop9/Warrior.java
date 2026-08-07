package com.oop9;

public class Warrior {

    private String name;
    private int level;
    private int hp;

    // 생성자
    public Warrior(String name) {
        this.name = name;
        this.level = 1;
        this.hp = 100;
    }

    // getter 메서드

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    // setter 메서드 (필요하다면)
    // 체이닝을 위해 스스로를 반환하는 setter를 작성해보았다.

    public Warrior setName(String name) {
        this.name = name;

        return this;
    }

    public Warrior setLevel(int level) {
        // 방어적 코딩 적용
        if (level <= 0) {
            System.out.println("0 또는 더 작은 값을 입력할 수 없습니다.");
            return this;
        }

        this.level = level;

        return this;
    }

    public Warrior setHp(int hp) {
        // 방어적 코딩 적용
        if (hp < 0) {
            System.out.println("0보다 작은 값을 입력할 수 없습니다.");
            return this;
        }

        this.hp = hp;

        return this;
    }

    // 아래 일반 메서드

    public Warrior levelUp() {

        level++;
        hp += 50;
        System.out.println(name + "의 현재 레벨은 " + level + "입니다.");

        return this;
    }

}
