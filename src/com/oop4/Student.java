package com.oop4;

/**
 * 생성자(constructor)
 *  객체를 생성할 때 호출되는 그것. 반드시 존재해야 한다.
 */
public class Student {

    int id;
    String name;
    int grade;

    //public Student() {}

    // 생성자.
    //  메서드와 구분 되는 점
    //  1. 리턴 타입 없음
    //  2. 클래스명과 일치(대소문자까지)
    public Student(int n, String s, int g) {
        // 생성자는 객체를 인스턴스화할 때 가장 먼저 실행되는 코드이다.
        id = n;
        name = s;
        grade = g;
    }

    public void showInfo() {
        System.out.println("----상태창----");
        System.out.println("학번: " + id);
        System.out.println("성명: " + name);
        System.out.println("학년: " + grade);
    }

}
