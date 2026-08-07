package com.oop7;

public class Rice {

    private String name;
    private int amount;

    public Rice(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    // 밥 소모
    public boolean reduce(int amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
            System.out.println(amount + " 만큼의 " + name + "을 소모합니다.");

            return true;
        } else {
            System.out.println(name + "이(가) 부족하여 소모할 수 없습니다.");

            return false;
        }
    }

}
