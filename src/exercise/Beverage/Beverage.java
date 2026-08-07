package exercise.Beverage;

// Beverage는 추상 클래스이다. 따라서 "new Beverage()"는 불가능하다.
public abstract class Beverage {
    // "name"과 "price"는 private이므로 자식이 직접 접근할 수 없고 getter로 읽어야 한다.
    private String name;
    private int price;

    public Beverage(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    // "prepare()"는 추상 메서드이므로 자식이 반드시 구현해야 한다.
    public abstract void prepare();

    // "serve()"는 일반 메서드이므로 모든 자식이 그대로 물려받는다.
    public void serve() {
        System.out.println(getName() + " 나왔습니다. 가격은 " + getPrice() + "원 입니다.");
    }
}
