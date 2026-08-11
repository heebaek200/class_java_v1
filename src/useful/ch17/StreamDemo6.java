package useful.ch17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// sorted 예제
public class StreamDemo6 {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5, 3, 1, 4, 2);

        // 오름차순 정렬
        List<Integer> asc = numbers.stream()
                .sorted()
                .toList();
        System.out.println(asc);

        // 내림차순 정렬
        List<Integer> desc = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(desc);

    }


}
