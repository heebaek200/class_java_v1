package com.oop9;

public class WarriorTest {

    public static void main(String[] args) {
        Warrior w1 = new Warrior("광폭전사");
        Warrior w2 = new Warrior("일반전사");

        w1.levelUp();

        // getter, setter 메서드 사용해보기
        // 필드 멤버들은 private으로, 상태 변경은 메서드 통해서 이루어진다.
        w1
                .setHp(80)
                .setLevel(2)
                .setName("작은전사");

        System.out.println("------------------------");
        System.out.println("""
                %s의 현재 레벨은 %d,
                체력은 %d입니다.
                """.formatted(
                w1.getName(),
                w1.getLevel(),
                w1.getHp()
        ));


    }

}
