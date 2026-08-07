package exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 조건문
 */
public class Exercise5 {

    public static void main(String[] args) {
        // 0~100 외의 정수를 입력했을 때의 예외처리를 위한 커스텀 예외 클래스
        class InvalidScoreException extends RuntimeException {
            public InvalidScoreException(String message) {
                super(message);
            }
        }

        int score;
        char grade;
        String comment;

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("성적을 입력하세요: ");
            try {
                // 정수값 입력
                score = sc.nextInt();

                if (score > 100 || score < 0) {
                    throw new InvalidScoreException("");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("정수가 아닙니다. 다시 시도하세요.");
                sc.next();

                // 적절한 안내 메시지를 출력하고 프로그램을 종료
                sc.close();
                return;
            } catch (InvalidScoreException e) {
                System.out.println("잘못된 입력입니다. 성적은 0에서 100 사이로 입력해주세요.");

                // 적절한 안내 메시지를 출력하고 프로그램을 종료
                sc.close();
                return;
            }
        }

        // 학점과 메세지
        if (score >= 90) {
            grade = 'A';
            comment = "우수한 성적이네요! 계속 좋은 성적 유지하길 바랍니다.";
        } else if (score >= 80) {
            grade = 'B';
            comment = "좋은 성적입니다. 조금만 더 노력하면 A도 가능해요!";
        } else if (score >= 70) {
            grade = 'C';
            comment = "괜찮은 성적이지만, 더 높은 등급을 위해 노력해봅시다.";
        } else if (score >= 60) {
            grade = 'D';
            comment = "학습에 더 집중할 필요가 있어요. 도움이 필요하면 말해주세요.";
        } else {
            grade = 'F';
            comment = "불합격입니다. 부족한 부분을 파악하고, 추가 학습이 필요해요.";
        }
        System.out.printf("당신의 학점은 %s 입니다.\n", grade);
        System.out.println(comment);

        sc.close();

    }

}
