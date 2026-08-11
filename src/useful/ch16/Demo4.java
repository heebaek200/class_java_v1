package useful.ch16;

public class Demo4 {

    public static void main(String[] args) {

        // 단계적으로 줄여 써보기
        //MathOperation add = (int x, int y) -> { return x + y; };

        // 1. 매개변수 타입 생략
        MathOperation add = (x, y) -> { return x + y; };
        
        // 2. 구현부 중괄호와 return 생략
        MathOperation subtract = (x, y) -> x - y;

        // 주의: 만약 구현부가 여러줄이면 중괄호와 return을 생략할 수 없다.
        MathOperation devide = (x, y) -> {
            if (y == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return x / y;
        };


        System.out.println("10 + 10 = " + add.operate(10, 10));
        System.out.println("10 - 10 = " + subtract.operate(10, 10));
        System.out.println("10 * 10 = " + devide.operate(10, 10));
        

    }

}
