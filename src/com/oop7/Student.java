package com.oop7;

public class Student {

    private String name;
    private int money;

    public Student(String name, int money) {
        this.name = name;
        this.money = money;
    }

    // 식사
    public void eatRice(Rice rice) {
        int amount = 500;

        System.out.println(name + " 학생은 " + amount + "만큼의 식사를 합니다.");

        rice.reduce(amount);
    }

    // 타다.
    public void rideVehicle(Rideable rideable) {
        money = rideable.ride(money);
    }

    // 정보 확인
    public void showInfo() {
        System.out.println(name + " 학생은 " + money + " 원을 가지고 있습니다.");
    }

}
