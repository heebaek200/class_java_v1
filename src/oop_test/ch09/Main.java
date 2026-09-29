package oop_test.ch09;

public class Main {

    public static void main(String[] args) {
        OrderDao orderDao = new MemoryOrderDao();
        // OrderDao orderDao = new LogOrderDao();

//        DiscountPolicy discountPolicy = new FixDiscountPolicy();
        DiscountPolicy discountPolicy = new RateDiscountPolicy();

        OrderService orderService = new OrderService(orderDao, discountPolicy);

        orderService.takeOrder("아메리카노", 4_500);
        orderService.takeOrder("카페라떼"  , 5_000);
        orderService.takeOrder("바닐라라떼", 5_500);

        orderService.printAllOrders();
    }
}
