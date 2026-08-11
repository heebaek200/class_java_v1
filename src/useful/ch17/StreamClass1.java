package useful.ch17;

import java.util.*;

/**
 * 나이 목록에서 18세 이상을 골라내는 코드를 두가지 방법을로 알아보자.
 */
public class StreamClass1 {

    public static void main(String[] args) {

        List<Integer> ages = new ArrayList<>();
        ages.add(20);
        ages.add(11);
        ages.add(18);
        ages.add(24);
        ages.add(33);
        ages.add(40);
        ages.add(2);

        // 위를 한 번에 해결하는 방법을 따로 소개 (Arrays.asList)
        int[] arr = {1, 2, 3};
        ages = Arrays.asList(20, 11, 18, 24, 33, 40, 2);

        // 탐색 방법1. 지금까지 배운 방식
        List<Integer> adultAges1 = new ArrayList<>();
        for (int age: ages) {
            if (age >= 18) {
                adultAges1.add(age);
            }
        }
        System.out.println("for문 방식 결과 : " + adultAges1);

        // 탐색 방법2. 스트림 방식
        //List<Integer> adultAges2 = ages.stream().filter((age) -> { return age >= 18; }).toList();
        List<Integer> adultAges2 = ages
                .stream()
                .filter(age -> age >= 18)
                .toList();
        System.out.println("Stream : " + adultAges2);

    }

}
