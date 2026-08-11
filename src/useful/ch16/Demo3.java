package useful.ch16;

// 자바 API에서 제공해주는 것 말고, 직접 함수형 인터페이스를 설계해보자

public class Demo3 {

    public static void main(String[] args) {

        // 함수형 인터페이스 타입에 람다식을 담을 수 있다.
        MathOperation add = (int x, int y) -> {
            return x + y;
        };

        MathOperation subtract = (int x, int y) -> { return x - y; };
        MathOperation multiply = (int x, int y) -> { return x * y; };
        MathOperation divide = (int x, int y) -> { return x / y; };

        // 실행해보기. (주의: 호출할 때는 인터페이스에 정의된 메서드까지 명시)
        System.out.println("10 + 10 = " + add.operate(10, 10));
        System.out.println("10 - 10 = " + subtract.operate(10, 10));
        System.out.println("10 * 10 = " + multiply.operate(10, 10));
        System.out.println("10 / 10 = " + divide.operate(10, 10));


    }

}
