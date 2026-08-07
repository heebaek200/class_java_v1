package ch07;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WhileTest3 {

    public static void main(String[] args) {
        // 1. 1..10 합계를 while 문으로 작성
        // 2. 끝 값을 스캐너를 통해 입력 받기

        // 1 미만의 정수를 입력했을 때의 예외처리를 위한 커스텀 예외 클래스
        class InvalidScoreException extends RuntimeException {
            public InvalidScoreException(String message) {
                super(message);
            }
        }

        long end;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("숫자를 입력하세요: ");
            try {
                // 정수값 입력
                end = sc.nextLong();

                if (end < 1) {
                    throw new InvalidScoreException("");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("정수가 아닙니다. 다시 시도하세요.");
                sc.next();
            } catch (InvalidScoreException e) {
                System.out.println("잘못된 입력입니다. 양의 정수를 입력해주세요.");
            }
        }

        long i = 1;
        long sum = 0;
        while (i <= end) {
            if (sum + i > Long.MAX_VALUE) {
                System.out.printf("오버플로우 발생. i: %d, end: %d", i, sum);
                break;
            }
            sum += i;
            i++;
        }

        System.out.println("합계 : " + sum);

        sc.close();
    }

}
