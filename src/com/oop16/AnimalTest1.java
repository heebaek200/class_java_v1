package com.oop16;

import com.oop14.Cat;

public class AnimalTest1 {

    public static void main(String[] args) {

        // 1. 자기 타입으로 바라보기
        Animal animal1 = new Animal();
        animal1.move();
        animal1.eating();
        System.out.println("----------------------------");

        // 2. 부모 타입으로 자식 객체 바라보기 (Upcasting)
        Animal animal2 = new Tiger();
        animal2.move();
        animal2.eating();

        // 3. 다운캐스팅 작성해보기
        Tiger tiger = (Tiger) animal2;      // 강제 형변환
        tiger.hunting();                    // Tiger의 메소드 호출 가능
        System.out.println("----------------------------");

        // 2.1.
        Animal animal3 = new Human();
        animal3.move();
        animal3.eating();
        System.out.println("----------------------------");

        // 문제 확인
        // animal3.readBook() <- 에러 발생 (Human 객체는 맞지만 컴파일 시점에 Animal 타입이므로 readBook()을 호출할 수 없음)



    } // end of main method

}
