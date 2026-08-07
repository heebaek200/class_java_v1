package ch05;

import java.util.List;
import java.util.function.Predicate;

public class Operation2 {
    public static void main(String[] args) {
        System.out.println(5 + 3);
        System.out.println(5 - 3);
        System.out.println(5 * 3);
        System.out.println(5 / 3);
        System.out.println(5 / (double)3);
        System.out.println(5 % 3);

        // 문제1
        // (12+3)/3
        // 조건: 결과값을 변수에 담아서
        int result = (12 + 3) / 3;
        System.out.println("(12 + 3) / 3 = " + result);

        // 문제2
        // (25 % 2)
        int result2 = 25 % 2;
        System.out.println("25 % 2 = " + result2);

        // 문제3
        // 7896456이 홀수인지 짝수인지 판별
        Predicate<Integer> isEven = num -> num % 2 == 0;

        List<Integer> numbers = List.of(7896456);

        System.out.println("--- 짝수 목록만 추출 ---");
        numbers.stream()
                .filter(isEven)
                //.forEach(System.out::println);
                .forEach(x -> System.out.println(x));
    }
}
