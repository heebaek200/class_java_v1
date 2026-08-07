package com.oop16;

public class Apple extends Fruit {
    // 상속 받은 멤버: name, price, showInfo


    public Apple() {
        this.name = "사과";
        this.price = 3000;
    }


    // 정률 할인(10% 할인)
    public void saleApple() {
        int discount = price / 10;
        price -= discount;
        System.out.println("사과 10% 할인. 현재 가격: " + price);

    }

}
