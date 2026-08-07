package ch08;

public class BreakTest2 {

    public static void main(String[] args) {

        // 1~100 반복문을 진행하고, 3의 배수만 출력하며, 50이상이면 반복문을 종료. for문 사용

        for (int i = 1 ; i <= 100 ; i += 3) {
            System.out.println("i : " + i);
            if (i >= 50) break;
        }

    }

}
