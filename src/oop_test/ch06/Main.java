package oop_test.ch06;

public class Main {
    public static void main(String[] args) {
        // 1. 사용할 부품 (Dao)를 먼저 생성
        OrderDao orderDao = new OrderDao();

        // 2. 서비스 객체를 생성할 때, 부품(Dao)를 주입받도록 설계되어 있음.
        OrderService service = new OrderService(orderDao);  // DI

        // 3. 동작 확인
        service.takeOrder("아메리카노", 4_500);
        service.takeOrder("라떼", 5_000);
        service.takeOrder("바닐라 라떼", 5_500);

        service.printAllOrders();
    }
}
