package ch03;

public class ConstantTest2 {

    // 코드 실행의 시작점
    public static void main(String[] args) {
        // 도전 과제 - 스스로 상수를 사용해서 값을 화면에 출력해 보세요

        // 부가가치세율 10%를 상수로 지정
        final double VAT_RATE = 0.1;

        int price = 10000;
        double vat = price * VAT_RATE;

        System.out.printf("물건 가격: %d원, 부가세: %.0f원%n", price, vat);

    } // end of main

} // end of class
