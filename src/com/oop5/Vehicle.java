package com.oop5;

public abstract class Vehicle {
    private int count;          // 승객수
    private int money;          // 수익금

    // 승객을 태우다
    public Vehicle take(int pay) {
        this.money += pay;
        this.count++;

        return this;
    }

    public abstract void showInfo();


    // getter, setter
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
