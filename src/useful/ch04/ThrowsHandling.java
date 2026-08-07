package useful.ch04;

public class ThrowsHandling {

    public static void main(String[] args) {

        Calc calc = new Calc();
        try {
            calc.divide(100, 0);
        } catch (Exception e) {
            System.out.println("어떤 수로 0으로 나눌 수 없습니다.");
        }

    } // end of main

} // end of class



// Calc 클래스 설계
class Calc {

    // throws : 예외처리를 사용하는 측에서 직접 다루도록 던지기
    // 강제성이 발생됨 (사용하는 측에서 반드시 처리해야 함)
    public int divide(int n1, int n2) throws DivideByZeroException {
        System.out.println("나누기 동작");

        return n1 / n2;
    }

}

