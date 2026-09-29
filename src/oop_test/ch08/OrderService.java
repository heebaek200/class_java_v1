package oop_test.ch08;

import java.text.NumberFormat;

public class OrderService {

    // 인터페이스로 참여
    private DiscountPolicy discountPolicy;

    // 할인 정책 구현 클래스 의존성 주입
    public OrderService(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }


    public void takeOrder(String menuName, int price) {
        Order newOrder = new Order(menuName, price);
        int discountAmount = discountPolicy.discount(newOrder.getPrice());

        int finalPrice = newOrder.getPrice() - discountAmount;

        System.out.println(
                "%s | 정가 : %s 원 | 할인 : %s 원 | 결제 금액 : %s 원".formatted(
                        newOrder.getMenuName(),
                        NumberFormat.getInstance().format(newOrder.getPrice()),
                        NumberFormat.getInstance().format(discountAmount),
                        NumberFormat.getInstance().format(finalPrice)
                ));


    }
}
