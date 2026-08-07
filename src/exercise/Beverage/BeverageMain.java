package exercise.Beverage;

public class BeverageMain {

    public static void main(String[] args) {
        Beverage beverage1 = new Americano();
        Beverage beverage2 = new Latte();

        System.out.println("-------------------------");
        beverage1.prepare();
        beverage1.serve();

        System.out.println("-------------------------");
        beverage2.prepare();
        beverage2.serve();

        System.out.println("-------------------------");
        System.out.println("주문: " + beverage1.getName() + ", " + beverage2.getName());
        System.out.println("총 금액: " + (beverage1.getPrice() + beverage2.getPrice()) + "원");
    }

}
