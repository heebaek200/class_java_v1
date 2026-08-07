package com.oop10;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Calculator {

    // static 메서드 (객체 생성 없이도 클래스.메서드()로 사용가능)
    //  사용 예: 객체 마다 결과가 달라질 이유가 없을 때
    public static int add(int n1, int n2) {
        return n1 + n2;
    }

    // 일반 인스턴스 메서드 (객체를 생성해서 사용 가능)
    public int muliply(int n1, int n2) {
        return n1 * n2;
    }

    // main 함수
    public static void main(String[] args) {

        // 자바 표준 API 사용해보기
        double ran = Math.random();

        System.out.println(ran);

        // Random API
        Random random = new Random();

        int ranInt = random.nextInt();
        System.out.println(ranInt);

        int lottoNumber1 = random.nextInt(45) + 1; // 1~45 범위
        System.out.println(lottoNumber1);


    } // end of main

}
