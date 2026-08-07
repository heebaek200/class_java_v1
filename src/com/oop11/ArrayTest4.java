package com.oop11;

import java.util.Objects;

public class ArrayTest4 {

    public static void main(String[] args) {

        // 문자열 배열
        String[] names = new String[10];

        // Create
        names[0] = "김피카";
        names[1] = "이꼬북";
        names[2] = "박이상";

        names[9] = "최파이";

        // Read (foreach 사용)
        for (String s: names) {
            // null이 아닐 때만 출력하기: isNull메서드 사용
            if (!Objects.isNull(s)) {
                System.out.println(s);
            }
        }


    }

}
