package com.oop15;

public class CarMainTest {


    public static void main(String[] args) {

        Car car = new Car("BMW");
        car.start();
        System.out.println("--------------------");

        // 합성 관계: 밖에서는 Engine 객체를 접근할 방법이 없도록 한다.


    } // end of main method

}
