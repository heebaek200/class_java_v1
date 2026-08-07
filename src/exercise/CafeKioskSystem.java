package exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CafeKioskSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1 미만 정수를 입력했을 때의 예외처리를 위한 커스텀 예외 클래스
        class InvalidScoreException extends RuntimeException {
            public InvalidScoreException(String message) {
                super(message);
            }
        }

        final int PRICE_COFFEE = 2500;
        int inputInt;

        while (true) {
            System.out.print("몇 잔의 커피를 주문하시겠습니까?: ");
            try {
                // 정수값 입력
                inputInt = sc.nextInt();

                if (inputInt < 1) {
                    throw new InvalidScoreException("");
                } else {

                    int amount = PRICE_COFFEE * inputInt;
                    System.out.println("총 결제 금액: " + amount + "원");
                    if (inputInt >= 3) {
                        System.out.println("3잔 이상 구매 서비스 스탬프 발급:");
                        for (int i = 0 ; i < 3 ; i++) {
                            for (int j = 0 ; j < 3 ; j++) {
                                System.out.print('*');
                            }
                            System.out.println();
                        }
                    }

                }
            } catch (InputMismatchException e) {
                System.out.println("정수가 아닙니다. 다시 시도하세요.");
                sc.next();
            } catch (InvalidScoreException e) {
                System.out.println("잘못된 입력입니다. 1잔 이상의 커피를 주문해주세요.");
            }
        }

    }
}