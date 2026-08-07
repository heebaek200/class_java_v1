package exercise;


import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 반복문
 */
public class Exercise6 {

    public static void main(String[] args) {
        // 1부터 사용자가 입력한 숫자까지의 모든 짝수 합을 계산하는 프로그램을 작성하시오.
        // for 반복문을 단일로 사용하시오.

        // 1 이하의 정수를 입력했을 때의 예외처리를 위한 커스텀 예외 클래스
        class InvalidScoreException extends RuntimeException {
            public InvalidScoreException(String message) {
                super(message);
            }
        }

        int inputInt;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("숫자를 입력하세요: ");
            try {
                // 정수값 입력
                inputInt = sc.nextInt();

                if (inputInt < 1) {
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

        int sum = 0;
        for (int i = 1 ; i <= inputInt ; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }

        System.out.printf("입력한 값 %d까지 짝수의 합은 %d입니다.", inputInt, sum);

        sc.close();
    }

}
