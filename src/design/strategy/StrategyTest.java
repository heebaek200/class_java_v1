package design.strategy;

public class StrategyTest {


    public static void main(String[] args) {
        String message = "hello Java 안녕";

        Encoder encoder = new Encoder(new Base64Strategy());
        System.out.println(encoder.encode(message));

        encoder.setStrategy(new HexStrategy());
        System.out.println(encoder.encode(message));
    }
}
