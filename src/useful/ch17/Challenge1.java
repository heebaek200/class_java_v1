package useful.ch17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Challenge1 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // ## 도전 문제 1. 짝수만 골라 제곱하기
        // 숫자 리스트에서 짝수만 필터링한 뒤, 각 짝수를 제곱하여 리스트로 반환하시오.


        // 뭔가 걸러야하니까? filter써볼까?

        List<Integer> result = numbers.stream()
                .filter(n -> (n % 2) == 0)
                .map(n -> n * n)
                .toList();

        System.out.println(result);


        // 도전 과제 2. 반대로, StreamAPI가 아닌 방식으로 만들어보기

        // for i 방식
        List<Integer> result2 = new ArrayList<>();
        for (int i = 0 ; i < numbers.size() ; i++) {
            int n = numbers.get(i);
            if (n % 2 == 0) {
                result2.add(n * n);
            }
        }
        System.out.println(result2);

        // forEach 방식
        List<Integer> result3 = new ArrayList<>();
        numbers.forEach(n -> {
            if (n % 2 == 0) {
                result3.add(n * n);
            }
        });
        System.out.println(result3);

    }

}
