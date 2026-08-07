package com.oop11;

public class ArrayTest1 {

    public static void main(String[] args) {

        // 배열(Array)
        // 'int배열 타입임'
        int[] 정수배열1 = new int[3];
        int 정수배열2[] = new int[3];       // 동일 방법

        // 💡- 초기값으로 배열 길이를 지정해야 함
        // 정수배열1의 길이는 3, 인덱스 크기는 2(=3-1)

        정수배열1[0] = 10;
        정수배열1[1] = 20;
        정수배열1[2] = 30;
        // 정수배열1[3] = 40;  // Array Index Out of Bounds Exception


        // 배열 선언 2번 째
        int[] gradeArray  = new int[]{1, 2, 3};
        int[] gradeArray2 = {1, 2, 3};



        double[] dArr = new double[5];
        dArr[0] = 0.1;
        dArr[1] = 0.2;

        for (int i = 0 ; i < dArr.length ; i++) {
            System.out.println(dArr[i]);
        }

        // 문제1
        // char 배열 2개 선언해서 초기화
        char[] charArray1 = new char[1];
        char[] charArray2 = {1, 2};


        // 문제2
        // boolean 배열 3개 선언해서 초기화
        boolean[] boolArray1 = new boolean[1];
        boolean boolArray2[] = new boolean[2];
        boolean[] boolArray3 = {true, true, false};



    }

}
