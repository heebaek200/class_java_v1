package ch06;

// import
import java.util.Scanner;

/**
 * 조건문
 */
public class IfTest3_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("키보드로 값을 입력해주세요...");
        int age = sc.nextInt();

        if (age <= 7) {
            System.out.println("학교에 아직 안 다님");
        } else if (age <= 13) {
            System.out.println("초등학생");
        } else if (age <= 16) {
            System.out.println("중학생");
        } else if (age <= 19) {
            System.out.println("고등학생");
        }

        System.out.println("프로그램 종료");

    }

}
