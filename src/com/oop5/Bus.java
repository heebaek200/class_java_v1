package com.oop5;

public class Bus extends Vehicle {

    private int busNumber;
    // 멤버 변수를 생성자를 통해서 초기화하지 않으면 자동으로 기본값을 가지게 된다. int는 0, double은 0.0, boolean는 false

    // 생성자
    public Bus(int busNumber) {
        this.busNumber = busNumber;
    }

    // 현재 버스의 상태를 보여주는 메서드
    public void showInfo() {
        System.out.println("버스 번호: " + getBusNumber());
        System.out.println("현재 승객 수:" + getCount());
        System.out.println("현재 수익 금액: " + getMoney());
    }


    // getter, setter
    public int getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(int busNumber) { this.busNumber = busNumber; }
}
