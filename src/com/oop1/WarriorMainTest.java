package com.oop1;

public class WarriorMainTest {

    // 코드 실행 진입점
    public static void main(String[] args) {

        // new: 키워드, Warrior(): 생성자 호출
        Warrior w1 = new Warrior();

        w1.name = "티모";
        w1.height = 10.5;
        w1.health = 100;
        w1.attackPower = 70;
        w1.defensePower = 30;

        // w1 참조 변수에 접근해서 값을 할당해 보자.
        // 객체의 접근은 「.」 연산자를 통해 할 수 있다.
        System.out.println("w1 주소 : "   + w1);
        System.out.println("w1 이름 : "   + w1.name);
        System.out.println("w1 체력 : "   + w1.health);
        System.out.println("w1 공격력 : " + w1.attackPower);
        System.out.println("w1 방어력 : " + w1.defensePower);
        System.out.println("w1 키 : "     + w1.height);

        System.out.println("------------------------------------");

        // Warrior2
        Warrior w2 = new Warrior();

        w2.name = "가렌";
        w2.height = 60.5;
        w2.health = 200;
        w2.attackPower = 100;
        w2.defensePower = 150;

        System.out.println("w2 주소 : "   + w2);
        System.out.println("w2 이름 : "   + w2.name);
        System.out.println("w2 체력 : "   + w2.health);
        System.out.println("w2 공격력 : " + w2.attackPower);
        System.out.println("w2 방어력 : " + w2.defensePower);
        System.out.println("w2 키 : "     + w2.height);



    }

}
