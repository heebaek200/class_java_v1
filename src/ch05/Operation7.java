package ch05;

/**
 * 빠른 평가
 *  논리 연산에서 첫 조건이 결과를 결정할 경우 두 번째 조건을 평가하지 않는 특성
 */
public class Operation7 {
    public static void main(String[] args) {

        int number = 5;
        int index = 0;

        // 논리곱을 사용한 빠른 평가
        // 첫 조건이 false 이기 때문에 빠른 평가로 두 번 째 조건이 실행되지 않는 예시
        //boolean result = (number = number + 10) < 10 && (index = index + 2) < 10;
        boolean result = (number += 10) < 10 && (index += 2) < 10;
        System.out.println("number: " + number);
        System.out.println("index: " + index);

        // 논리합을 사용한 빠른 평가
        // number가 위의 연산으로 인해 15, index는 0
        boolean result2 = (number += 10) > 10 || (index += 2) < 10;
        System.out.println("number: " + number);
        System.out.println("index: " + index);

    }
}
