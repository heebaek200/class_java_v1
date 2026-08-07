package com.oop4;

public class CalculatorMain {

    // 두 숫자를 더하는 함수
    static int add(int a, int b) {return a+b;}

    // 두 숫자를 빼는 함수
    static int subtract(int a, int b) {return a-b;}

    // 두 숫자를 곱하는 함수
    static int muliply(int a, int b) {return a*b;}

    // 두 숫자를 나누는 함수
    static double divide(int a, int b) {
        if (b == 0) {
            System.out.println("0으로 나눌 수 없습니다.");
            return 0.0;
        } else {
            return (double)a / b;
        }
    }

    // 짝수 판별 함수
    static boolean isEvenNumber(int a) {return (a%2)==0;}

    // 홀수 판별 함수
    static boolean isOddNumber(int a) {return (a%2)==1;}

    public static void main(String[] args) {

        System.out.println(add(5, 6));
        System.out.println(subtract(6, 5));
        System.out.println(muliply(3, 7));
        System.out.println(divide(33, 11));
        System.out.println(isEvenNumber(9));
        System.out.println(isOddNumber(9));

    }

}
