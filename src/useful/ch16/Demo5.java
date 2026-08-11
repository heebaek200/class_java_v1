package useful.ch16;

public class Demo5 {

    public static void main(String[] args) {

        // 배웠던 '익명 내부 클래스'와 동작이 완전히 동일하다.

        MathOperation add1 = new MathOperation() {
            @Override
            public int operate(int x, int y) {
                return x + y;
            }
        };

        // 완전히 같은 동작의 람다식
        MathOperation add2 = (x, y) -> x + y;

        // 호출해보기
        System.out.println("익명 클래스 : " + add1.operate(100, 100));
        System.out.println("람다 표현식 : " + add2.operate(100, 100));

    }

}
