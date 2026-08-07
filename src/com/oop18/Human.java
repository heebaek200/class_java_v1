package com.oop18;

public abstract class Human extends Animal{

    // 추상메서드를 일반 구현 메서드로 오버라이드

//    @Override
//    public void hunt() {
//        System.out.println("사람이 도끼로 사냥을 합니다.");
//    }

    public static void main(String[] args) {
        // 이제 인스턴스화 가능
        //Animal animal = new Human();
        //animal.hunt();
    }
}
