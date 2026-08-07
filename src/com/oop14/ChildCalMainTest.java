package com.oop14;

public class ChildCalMainTest {

    public static void main(String[] args) {

        ChildCal childCal = new ChildCal();
        System.out.println(childCal.sum(10, 10));
        System.out.println(childCal.multiply(10, 0));
        System.out.println(childCal.subtract(100, 1));

        // 수정 요청! 곱하기 기능 - n1와 n2에 0이 들어오면 0을 입력하지 마시오.
        // -> 메서드 오버라이드 활용

    } // end of main

} // end of class
