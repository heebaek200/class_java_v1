package com.oop15;

public class Car {

    private String name;
    private Engine engine;

    public Car(String name) {
        this.name = name;
        // 합성의 조건1. 매개변수로 받지 않고 생성자에서 직접 객체 생성.
        //    Car 객체를 생성할 때 Engine 객체도 함께 생성.
        this.engine = new Engine("v8");

    }

    // 합성의 조건2. getter를 만들지 않는다.

    public void start() {
        engine.start();
        System.out.println(name + " 자동차가 출발합니다.");
    }

    public void stop() {
        engine.stop();
        System.out.println(name + " 자동차가 정지합니다.");
    }

}
