package ch07;

/**
 * 반복문
 */
public class ForTest2 {

    public static void main(String[] args) {
        // 화면에 구구단을 출력하시오.
        for (int std = 2 ; std <= 9 ; std++) {
            System.out.println(std + "단:");
            for (int i = 1; i <= 9; i++) {
                System.out.printf("%d × %d = %d\n", std, i, std * i);
            }
        }

    }
}
