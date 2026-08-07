package com.oop16;

public class FruitMainTest {

    public static void main(String[] args) {

        // 하나의 객체를 다양한 타입으로 바라볼 수 있다.
        Fruit fruit1 = new Banana();     // __업캐스팅된 상태__
        Fruit fruit2 = new Peach();

        fruit1.showInfo();
        System.out.println("-----------------------------");
        fruit2.showInfo();

        // 문제: 바나나의 원산지 정보는 어떻게 출력할까?
        // fruit1.getOrigin();      // <- 컴파일 에러: Fruit 타입에는 getOrigin()이 없다.

        // 해결방안: 다운캐스팅으로 컴파일러의 시선을 Banana로 바꾼다.
        String result = ((Banana) fruit1) .getOrigin();
        System.out.println("바나나 원산지: " + result);

        // ↑ 이런 코드는 컴파일러는 통과하지만 위험하다. ClassCastException 발생 가능성 있음.




    } // end of main

}
