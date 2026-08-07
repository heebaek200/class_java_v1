package ch06;

/**
 * 조건문
 */
public class IfTest3 {

    public static void main(String[] args) {

        // if ... else if ...

        int age = 17;

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
