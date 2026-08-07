package com.oop19;

public abstract class Car {

    //final private String name;

    private void startCar() {
        System.out.println("시동을 켭니다.");
    }

    private void turnOff() {
        System.out.println("시동을 끕니다.");
    }

    protected abstract void drive();
    protected abstract void stop();

    // 핵심: 이 메서드를 템플릿 메서드로 설계하겠다.
    // 실행의 흐름이 미리 정의되어 있는 템플릿. - 반드시 final 키워드를 선언해준다.
    final public void run() {
        startCar();         // 1. 시동걸기
        drive();            // 2. 운전하기
        stop();             // 3. 정지하기
        turnOff();          // 4. 시동끄기
    }

}
