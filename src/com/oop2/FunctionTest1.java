package com.oop2;

public class FunctionTest1 {

    // 1. 함수를 설계해보자
    // 두 정수값 n1, n2를 받아서, n1와 n2의 합을 반환하는 함수를 설계
    static int add(int n1, int n2) {
        int result;
        result = n1 + n2;

        // return <- 값을 반환
        return result;
    }


    // 2. 함수 사용하기
    // 코드 실행의 시작점
    public static void main(String[] args) {

        System.out.println("내가 설계한 함수를 사용해보자.");
        // 함수 이름 호출

        int result1 = add(10, 20);

        System.out.println("result 1: " + result1);

    }


}
