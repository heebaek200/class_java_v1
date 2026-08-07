package exercise.Beverage;

public class Americano extends Beverage {

    // Americano와 Latte의 생성자에는 매개변수가 없다. 이름과 가격을 클래스 안에서 직접 정해서 "super()"로 넘긴다는 뜻이다.
    public Americano() {
        super("아메리카노", 3_000);
    }

    @Override
    public void prepare() {
//        System.out.println(getName() + "를 준비합니다...");
        System.out.println("에스프레소에 물을 붓습니다.");
    }
}
