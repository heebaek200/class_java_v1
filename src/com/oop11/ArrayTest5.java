package com.oop11;

import java.util.Random;
import java.util.StringJoiner;

public class ArrayTest5 {

    // 로또 6자리 번호 배열 반환하는 메서드
    public static int[] makeNumber() {
        Random random = new Random();
        int[] lotto = new int[6];

        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = random.nextInt(45) + 1;
        }

        return lotto;
    }


    public static void main(String[] args) {
        // StringJoiner 사용
        StringJoiner sj = new StringJoiner(", ");

        for (int i: makeNumber()) {
            sj.add(String.valueOf(i));
        }

        System.out.println(sj.toString());


    }

}
