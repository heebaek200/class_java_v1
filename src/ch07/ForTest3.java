package ch07;

public class ForTest3 {
    public static void main(String[] args) {
        // A 1..100 총합을 구하시오
        // B 홀수의 총합을 구하시오
        int sum = 0;
        int sumOdd = 0;
        for (int i = 1 ; i <= 100 ; i++) {
            sum += i;
            if (i % 2 == 1) {
                sumOdd += i;
            }
        }

        System.out.println("1부터 100까지의 총합은 " + sum + "입니다.");
        System.out.println("1부터 100까지 홀수의 총합은 " + sumOdd + "입니다.");

        // 2씩 증가시키기
        for (int i = 0 ; i < 10 ; i += 2) {
            System.out.println("2씩 증가 + " + i);
        }

        // 문제 - 화면에 10 9 8 7 6 5 4 3 2 1을 출력하시오. for문 활용
        for (int i = 10 ; i >= 1 ; i--) {
            System.out.println(i);
        }
    }
}
