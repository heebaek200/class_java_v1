package com.oop5;

public class Student {

    private String name;
    private int money;

    // 생성자
    public Student(String n, int m) {
        this.name = n;
        this.money = m;
    }

    // 메서드1. 학생이 탈 것을 탄다.
    public void takeVehicle(Vehicle vehicle) {
        int pay = 1000;

        vehicle.take(pay);

        money -= pay;
    }

    // 메서드2. 정보창 보여주는 기능
    public void showInfo() {
        System.out.println(getName() + " 님의 현재 남은 금액: " + getMoney());
    }

    // 메서드3. 학생이 밥을 먹는다. (밥 양이 부족하면 밥을 못 먹었습니다.)
    public void eatRice(Rice rice) {
        boolean result = rice.eat();

        if (result) {
            System.out.println(name + " 학생이 " + rice.getMenu() + "을(를) 먹었습니다.");
        } else {
            System.out.println(name + " 학생이 " + rice.getMenu() + "을(를) 먹지 못했습니다.");
        }

    }

    // getter, setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
