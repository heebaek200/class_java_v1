package com.oop10;

public class NumberPrinterTest2 {

    public static void main(String[] args) {
        NumberPrinter printer1 = new NumberPrinter(1);
        NumberPrinter printer2 = new NumberPrinter(2);

        // static 변수는 모든 객체가 공유하는 변수를 만들 때 사용할 수 있다
        // 객체를 생성하기 전에도 사용할 수 있다.
        // 클래스 변수라고도 부른다.

        int a = printer1.waitNumber;
        System.out.println(a);

    }

}
