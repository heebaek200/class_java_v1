package com.oop1;

public class StudentMainTest1 {

    // 코드 실행의 시작점(메인 함수)
    public static void main(String[] args) {

        // 내가 설계한 클래스를 메모리에 직접 올려보자
        // 아래 명령을 통해 JVM(자바 가상 머신) 메모리에 올릴 수 있다.
        Student student1 = new Student(); // 인스턴스화
        Student student2 = new Student();

        System.out.println("s1 : " + student1);
        System.out.println("s2 : " + student2);

        int grade = 10;
        double height = 1.1;

        System.out.println("grade : " + grade);
        System.out.println("height : " + height);

        // 자바의 변수 분류 중 대분류 2종
        // 기본 변수: 실제 값이 담김
        // 참조 변수: 실제 값이 아닌 가상주소가 담김


    } // end of main
} // end of class
