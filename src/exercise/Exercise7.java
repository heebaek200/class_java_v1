package exercise;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// 함수만들기 예제
public class Exercise7 {

    /*
    **인사말 출력하기**

    - 함수 이름: **`greet`**
    - 입력: 이름(String)
    - 출력: 없음 (콘솔에 직접 출력)
    - 설명: 사용자의 이름을 입력받아 "안녕하세요, [이름]님!"이라고 콘솔에 출력하는 함수입니다.
     */
    static void greet(String name) {
        System.out.printf("안녕하세요, [%s]님!\n", name);
    }

    /*
    **제곱 계산하기**

    - 함수 이름: **`square`**
    - 입력: 정수(int)
    - 출력: 입력된 수의 제곱(int)
    - 설명: 하나의 정수를 입력받아 그 수의 제곱을 반환하는 함수입니다.
     */
    static int square(int a) {
        return a * a;
    }

    /*
    **수의 부호 판별**

    ( 입력값이 0 —> “ZERO” , 1 —>  “positive” , - 1  → “negative”)

    - 함수 이름: **`signOfNumber`**
    - 입력: 정수(int)
    - 출력: 문자열(String) - "positive", "negative", "zero"
    - 설명: 입력받은 정수의 부호에 따라 "positive", "negative", "zero" 중 하나를 반환합니다.
     */
    static String signOfNumber(int num) {
        if (num == 0) {
            return "ZERO";
        } else if (num > 0) {
            return "positive";
        } else { // (num < 0)
            return "negative";
        }
    }

    /*
    **나이 확인**

    - 함수 이름: **`checkAdult`**
    - 입력: 나이(int)
    - 출력: 성인 여부(Boolean)
    - 설명: 입력받은 나이가 18세 이상인지 확인하여 성인이면 **`true`**, 아니면 **`false`**를 반환합니다.
     */
    static boolean checkAdult(int age) {
        if (age >= 18) {
            return true;
        } else {
            return false;
        }
    }

    /*
    **최대값 찾기 함수**

    - 함수 이름: **`findMax`**
    - 입력: 정수 배열
    - 출력: 입력 받은 값 중 가장 큰 수
    - 설명: 입력받은 두 수중에서 가장 큰 값을 반환하는 함수를 작성하세요.
     */
    static int findMax(int a, int b) {
        return a > b ? a : b;
    }

    // 메인 함수
    public static void main(String[] args) {
        // 인사말 출력하기
        greet("이희백");

        // 인사말 출력하기: 람다식으로 구현
        Consumer<String> consumer1 = name -> System.out.printf("안녕하세요, [%s]님!\n", name);
        consumer1.accept("이희백");

        // 제곱 계산하기
        int param2 = 33;
        int result2 = square(param2);
        System.out.println(param2 + "의 제곱은: " + result2);

        // 제곱 계산하기: 람다식으로 구현
        Function<Integer, Integer> function1 = a -> a * a;
        System.out.println(param2 + "의 제곱은: " + function1.apply(param2));

        // 수의 부호 판별
        int param3 = -24601;
        String result3 = signOfNumber(param3);
        System.out.println(param3 + "의 부호는: " + result3);

        // 수의 부호 판별: 람다식으로 구현
        Function<Integer, String> function2 = num -> {
            if (num == 0) {
                return "ZERO";
            } else if (num > 0) {
                return "positive";
            } else { // (num < 0)
                return "negative";
            }
        };
        System.out.println(param3 + "의 부호는: " + function2.apply(param3));

        // 나이 확인
        int param4 = 37;
        boolean result4 = checkAdult(param4);
        System.out.println(param4 + "의 성인 여부는: " + result4);

        // 나이 확인: 람다식으로 구현
        Predicate<Integer> predicate4 = age -> age >= 18;
        System.out.println(param4 + "의 성인 여부는: " + predicate4.test(param4));

        // 두 수 중 최대값
        int param5 = 99;
        int result5 = findMax(param4, param5);
        System.out.println(param4 + ", " + param5 + " 중 큰 수는: " + result5);

        // 두 수 중 최대값: 람다식으로 구현
        BiFunction<Integer, Integer, Integer> biFunction5 = (a, b) -> a > b ? a : b;
        System.out.println(param4 + ", " + param5 + " 중 큰 수는: " + biFunction5.apply(param4, param5));

    }

}
