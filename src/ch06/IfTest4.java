package ch06;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 조건문
 */
public class IfTest4 {

    public static void main(String[] args) {
        class InvalidScoreException extends RuntimeException {
            public InvalidScoreException(String message) {
                super(message);
            }
        }

        int score;
        char grade;

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("성적을 입력하세요: ");
            try {
                score = sc.nextInt();

                if (score > 100 || score < 0) {
                    throw new InvalidScoreException("");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("[오류] 정수가 아닙니다. 다시 시도하세요.");
                sc.next();
            } catch (InvalidScoreException e) {
                System.out.println("[오류] 0에서 100 사이의 점수를 입력하세요.");
            }
        }

        if (score >= 90) {
            grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else if (score >= 70) {
            grade = 'C';
        } else if (score >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.printf("당신의 학점은 %s 입니다.", grade);

        sc.close();

    }

}
