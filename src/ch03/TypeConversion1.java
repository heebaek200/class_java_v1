package ch03;

/**
 * 형변환이란?
 * 데이터의 타입을 다른 타입으로 변경하는 것
 *  - 자동 형변환 / 강제 형변환
 */
public class TypeConversion1 {

    public static void main(String[] args) {

        int intDataBox = 100;
        double doubleDataBox;

        // 1. 자동형변환 (int to double)
        doubleDataBox = intDataBox;
        System.out.println("doubleDataBox: " + doubleDataBox);

        // 2. 강제형변환
        final double PI = Math.PI;
        int intBox = (int)PI;
        System.out.println("intBox: " + intBox);

        // 연습
        double interestRate;
        int discount;

        interestRate = 15.5;

        // 문제1. 아래 오류를 수정하시오.
        // discount = interestRate;
        discount = (int)interestRate;
        System.out.println("discount: " + discount);


        float floatBox = 10.5f;


    } // end of main

} // end of class
