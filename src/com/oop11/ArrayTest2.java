package com.oop11;

public class ArrayTest2 {

    public static void main(String[] args) {

        // 문자열 선언 방법
        String s1 = "Greetings";
        String s2 = new String("Greetings");


        // 문자열 배열
        String[] names = new String[5];

        // Create
        names[0] = "김피카";
        names[1] = "이꼬북";
        names[2] = "박이상";

        // Read
        System.out.println(names);
        System.out.println(names[0]);
        System.out.println(names[1]);
        System.out.println(names[2]);

        // Update
        names[0] = "김라이";
        names[1] = "이거북";
        names[2] = "박해꽃";

        // Delete
        names[0] = null;
        names[1] = null;
        names[2] = null;

        System.out.println(names);
        System.out.println(names[0]);
        System.out.println(names[1]);
        System.out.println(names[2]);
        System.out.println(names[3]);
        System.out.println(names[4]);

        // 배열 객체의 멤버 .length
        System.out.println("배열의 길이: " + names.length + ", 배열의 인덱스 크기: " + (names.length-1));





    }

}
