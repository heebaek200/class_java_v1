package oop_test.ch09;

import java.text.NumberFormat;
import java.util.List;

public class OrderService {

    // 인터페이스로 참여
    private OrderDao dao;
    private DiscountPolicy discountPolicy;

    // 구현 클래스 의존성 주입
    public OrderService(OrderDao dao, DiscountPolicy discountPolicy) {
        this.dao = dao;
        this.discountPolicy = discountPolicy;
    }

    public void takeOrder(String menuName, int price) {
        Order newOrder = new Order(menuName, price);
        int discountAmount = discountPolicy.discount(newOrder.getPrice());

        int finalPrice = newOrder.getPrice() - discountAmount;
        dao.insert(newOrder);

        System.out.println(
                "%s | 정가 : %s 원 | 할인 : %s 원 | 결제 금액 : %s 원".formatted(
                        newOrder.getMenuName(),
                        NumberFormat.getInstance().format(newOrder.getPrice()),
                        NumberFormat.getInstance().format(discountAmount),
                        NumberFormat.getInstance().format(finalPrice)
                ));

    }

    public void printAllOrders() {
        List<Order> orders = dao.findAll();
        System.out.println("--- 전체 주문 내역 ---");
        for (Order order : orders) {
            System.out.println("메뉴: " + order.getMenuName() + " | 가격: " + order.getPrice() + "원");
        }
    }
}
