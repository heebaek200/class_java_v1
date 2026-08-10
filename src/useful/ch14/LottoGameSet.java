package useful.ch14;

import java.util.*;

public class LottoGameSet {

    public static void main(String[] args) {

        Set<Integer> lotto = new HashSet<>();
        Random random = new Random();
        int count = 0;

        while (lotto.size() < 6) {
            int number = random.nextInt( 45 ) + 1;          // 1 ~ 45
            lotto.add(number);

            count++;
        }

        System.out.println("이번주 로또 번호 : " + lotto);
        System.out.println("while 문 반복 횟수 : " + count);

        // 정렬을 위해 set -> list로 변환
        List<Integer> sortedLotto = new ArrayList<>(lotto);

        System.out.println("------------------------------------------");
        System.out.println(sortedLotto);

        // 오름차순 정렬
        System.out.println("------------------------------------------");
        Collections.sort(sortedLotto);
        System.out.println(sortedLotto);
        
        // 내림차순 정렬
        // 방법1. reverseOrder() 메서드 쓰기
        System.out.println("------------------------------------------");
        Collections.sort(sortedLotto, Collections.reverseOrder());
        System.out.println(sortedLotto);

        // 방법2. 정렬 방법을 정의하는 익명 클래스를 구현해서 건내주기
        System.out.println("------------------------------------------");
        Collections.sort(sortedLotto, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(sortedLotto);

        System.out.println("---------");
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("A");
        set.add("C");
        System.out.println(set.size());

    }

}
