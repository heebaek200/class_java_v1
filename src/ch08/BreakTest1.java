package ch08;

public class BreakTest1 {

    public static void main(String[] args) {

        // i값이 7일 떄 멈추기
        for (int i = 0 ; i < 10 ; i++) {
            System.out.println("i : " + i);
            if (i == 7) break;
        }

        System.out.println("----------------------");

        // 문제1. 100..200까지 화면에 출력하시오.
        // 151에 도달했다면 반복문을 멈추기
        // while 문을 사용할 것
        int j = 100;
        while (j <= 200) {
            System.out.println(j);

            if (j == 151) break;
            j++;
        }

    }

}
