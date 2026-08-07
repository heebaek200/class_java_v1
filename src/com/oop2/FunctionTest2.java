package com.oop2;

public class FunctionTest2 {

    // 세개의 수를 입력받아 뺄셈하는 함수를 설계하고 그 값을 반환하는 함수를 만들어보자
    static int subtract (int a, int b, int c) {

        int result = a - b - c;

        return result;

    }

    // 리턴 키워드가 없는 함수를 만들어보자
    // 「void」
    static void sayHello(String greeting) {

        System.out.println("[[[ " + greeting + " ]]] 😊👍");

    }

    // 매개변수가 없는 함수를 설계해보자
    static int calcSum() {

        int sum = 0;
        int i;

        for (i = 1 ; i <= 100 ; i++) {
            sum += i;
        }

        return sum;

    }


    // 실행 시작점
    public static void main(String[] args) {

        int num1 = 10, num2 = 20;

        // static int subtract (int a, int b, int c)
        // 함수 호출 시 들어가는 값을 인수라고 한다.
        int result1 = subtract(num1, num2, (int)10.1);
        System.out.println(result1);

        sayHello("안녕 함수야");
        sayHello("안녕 함수야");
        sayHello("안녕 함수야");
        sayHello("안녕 함수야");
        sayHello("안녕 함수야");
        sayHello("안녕 함수야");
        sayHello("안녕 함수야");
        sayHello("안녕 함수야");
        sayHello("안녕 함수야");
        sayHello("안녕 함수야");
        sayHello("안녕 함수야");

        int result2 = calcSum();
        System.out.println(result2);


    }



}
