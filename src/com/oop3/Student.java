package com.oop3;

public class Student {

    // 속성. 필드. 클래스 영역에 선언된 변수를 멤버 변수라고 부를 수 있음.
    int studentId;
    String studentName;
    String address;

    // 행동.
    void study() {
        System.out.println(studentName + " 학생이 공부를 합니다.");
    }

    void breakTime() {
        System.out.println(studentName + " 학생이 휴식을 합니다.");
    }

    void showInfo() {
        System.out.println("----------------- 상태창 ------------------");
        System.out.println("학생 ID: "   + studentId);
        System.out.println("학생 이름: " + studentName);
        System.out.println("학생 주소: " + address);
    }

    void test() {
        System.out.println(studentName + " 학생이 시험을 칩니다.");
    }

    void clean() {
        System.out.println(studentName + " 학생이 청소를 합니다.");
    }

}
