package exercise;

@FunctionalInterface
interface MyCalculator {
    double calculate(double a, double b); // 단 하나의 추상 메서드
}

public class Exercise3 {
    public static void main(String[] args) {
        // 할인된 가격을 화면에 출력하는 코드 작성
        final double ORIGINAL_PRICE = 59.99;
        final double DISCOUNT_RATE = .3; // 30% 할인

        // 람다식 문법과 함수형 인터페이스를 사용해보기
        // 할인 계산식 찾아서 준비
        MyCalculator calculateDiscount = (price, rate) -> price * (1 - rate);

        // 할인된 계산 금액을 변수에 담아서 화면에 출력 (정수값으로)
        int discountedPrice = (int)calculateDiscount.calculate(ORIGINAL_PRICE, DISCOUNT_RATE);
        System.out.printf("할인된 가격: %d\n", discountedPrice);

    }
}
