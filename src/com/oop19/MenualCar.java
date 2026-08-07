package com.oop19;

public class MenualCar extends Car {

    @Override
    protected void drive() {
        System.out.println("사람이 핸들을 직접 조작하여 운전합니다.");
    }

    @Override
    protected void stop() {
        System.out.println("사람이 브레이크를 밟아서 정지합니다.");
    }

    // run() 재정의 불가
}
