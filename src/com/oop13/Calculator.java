package com.oop13;


// 메서드 오버로딩
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(1.0);
        System.out.println(true);
        System.out.println("This is a test");


    }
}
