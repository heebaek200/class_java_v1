package com.oop17;

public class Apple extends Fruit {
    // 상속 받은 멤버: name, price, showInfo


    public Apple() {
        this.name = "사과";
        this.price = 3000;
    }

    @Override
    public void sale() {
        int discount = price / 10;
        price -= discount;
        System.out.println("사과 10% 할인. 현재 가격: " + price);
    }


}
