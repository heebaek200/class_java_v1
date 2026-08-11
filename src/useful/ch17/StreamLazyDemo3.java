package useful.ch17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamLazyDemo3 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3);

        // 중간 연산만 호출하기
        System.out.println("[1] 중간 연산만 호출");
        Stream<Integer> stream1 = numbers.stream()
                .filter(n -> {
                    System.out.println("[2] fliter 실행 : " + n);
                    return n % 2 == 1;
                });

        System.out.println(" -----> 여기까지 출력된 filter 로그는? ");

        System.out.println("[3] 최종 연산 호출해보기");
        stream1.forEach(n -> System.out.println(" forEach 구문 실행 (최종 연산임) " + n));


    }

}
