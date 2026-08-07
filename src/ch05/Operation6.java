package ch05;

/**
 * 관계연산자
 *  연산의 결과는 true or false로 반환된다
 */
public class Operation6 {
    public static void main(String[] args) {

        int num1 = 100;
        int num2 = 200;

        // 논리곱 (&&)
        boolean flag1 = (num1 > 0) && (num2 > 0);
        System.out.println("flag1: " + flag1);
        boolean flag2 = (num1 > 0) && (num2 < 0);
        System.out.println("flag2: " + flag2);

        // 논리합 (||)
        boolean flag3 = (num1 > 0) || (num2 > 0);
        System.out.println("flag3: " + flag3);
        boolean flag4 = (num1 > 0) || (num2 > 0);
        System.out.println("flag3: " + flag4);

        // 부정 논리 (!)
        System.out.println(!true);
    }
}
