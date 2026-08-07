package ch05;

/**
 * 삼항연산자
 *  조건식 ? 결과1 : 결과2
 */
public class Operation8 {
    public static void main(String[] args) {
        int number = 7;

        char result1 = (number % 2 == 0) ? '짝' : '홀';
        System.out.println("result1: " + result1);


        boolean isOk = (5 > 3) ? true : false;
        System.out.println("isOk : " + isOk);


        int max = (10 > 1) ? 10 : 1;
        System.out.println("max : " + max);


        int n1 = 100;
        int n2 = 300;
        int max2;
        // n1 와 n2 값을 비교하여 더 큰 수를 max2 변수에 답는 코드를 삼항연산자를 사용하여 작성
        max2 = n1 > n2 ? n1 : n2;
        System.out.println("max2 : " + max2);

    }
}
