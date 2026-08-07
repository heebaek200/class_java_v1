package com.oop3;

public class StudentGame1 {
    public static void main(String[] args) {

        // 1. 객체 생성 (Heap 메모리에 할당)
        Student s1 = new Student();

        // 2. 참조 변수를 사용해서 객체에 접근하고 값 할당
        s1.studentId = 1;
        s1.studentName = "티모";
        s1.address = "푸른언덕";

        // 3. 생성된 객체의 동작을 호출
        s1.study();
        s1.breakTime();
        s1.showInfo();

        System.out.println("---------------------------");

        // 연습 문제
        s1.test();
        s1.clean();

        // 메서드란?
        // 객체 기능의 구현하기 위한 클래스 내부의 함수
        // 멤버 변수를 활용하여 기능을 구현한다.

        System.out.println("---------------------------");

        Student s2 = new Student();
        s2.studentId = 2;
        s2.studentName = "가렌";
        s2.address = "데마시아";

        s2.study();
        s2.test();
        s2.clean();
        s2.showInfo();

    }
}
