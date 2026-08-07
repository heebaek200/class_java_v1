package com.oop17;

public class Banana extends Fruit {
    // 상속 받은 멤버: name, price, showInfo

    // 바나나 전용 필드: 원산지
    private String origin;

    public Banana() {
        this.name = "바나나";
        this.price = 5000;
        this.origin = "필리핀";
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public void sale() {
        if (this.price <= 1000) {
            System.out.println("더 이상 할인할 수 없습니다.");
            return;
        }

        price -= 1000;
        System.out.println("바나나 가격을 할인합니다. 현재 가격: " + price);
    }
}
