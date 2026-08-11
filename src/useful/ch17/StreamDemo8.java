package useful.ch17;

import java.util.Arrays;
import java.util.List;

// 메서드 참조
public class StreamDemo8 {

    public static void main(String[] args) {

        // 각 문자열의 길이를 담는 배열을 스트림으로 생성하시오.
        List<String> words = Arrays.asList("a1", "bb2", "ccc3", "dddd4");

        words
                .stream()
                .map(s -> s.length())
                .forEach(e -> System.out.println("길이 : " + e));

        // 람다식이 그 매개변수를 그대로 호출하는 형태일 때 더 짧게 줄여서 쓸 수 있다.
        words
                .stream()
                .map(String::length)
                .forEach(e -> System.out.println("길이 : " + e));


    }


}
