package useful.ch04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FinallyHandling {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자를 입력하시오 : ");
        try {

            int result = scanner.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("입력 타입이 틀림");
        } catch (Exception e) {
            System.out.println("예상 범위 외의 오류 발생");
        } finally {
            scanner.close();
        }

        System.out.println("----------------------------------");
        System.out.println("프로그램이 정상 종료됨");

    } // end of main

}
