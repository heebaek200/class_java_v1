package com.oop18;

public abstract class Animal {

    // 추상 클래스(Abstract Class)란?
    // 클래스 앞에 abstract 키워드가 있고 추상 메서드를 포함한 클래스

    String name;
    public void move() {
        System.out.println("이동합니다.");

    }

    // 추상 메서드 - 하나라도 존재한다면 그 클래스는 추상 클래스여야 한다.
    public abstract void hunt();


    public static void main(String[] args) {

        // 추상 클래스는 직접 인스턴스화할 수 없다.
        // Animal animal = new Animal();  <- 직접 new 키워드 사용 불가

    } // end of main

}
