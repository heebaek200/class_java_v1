package com.oop10;

import java.util.Scanner;

public class MainTest1 {
    public static void main(String[] args) {
        Employee emp1 = new Employee("홍길동", "개발팀");
        Employee emp2 = new Employee("이몽룡", "디자인팀");
        Employee emp3 = new Employee("성춘향", "경영팀");

        System.out.println(emp1.getEmployeeNumber());
        System.out.println(emp2.getEmployeeNumber());
        System.out.println(emp3.getEmployeeNumber());

        // 카드를 새로 발급 받을 때 새로운 카드 번호 부여
        int nextCardNumber1 = Card.currentCardSerial++;
        System.out.println("새 카드 번호: " + nextCardNumber1);

        int nextCardNumber2 = Card.currentCardSerial++;
        System.out.println("새 카드 번호: " + nextCardNumber2);

        // 새로운 학번 생성
        int nextStudentNumber1 = Student.currentStudentSerial++;
        System.out.println("새 학번: " + nextStudentNumber1);

        int nextStudentNumber2 = Student.currentStudentSerial++;
        System.out.println("새 학번: " + nextStudentNumber2);

    }
}
