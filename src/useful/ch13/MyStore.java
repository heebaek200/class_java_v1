package useful.ch13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyStore {


    public static void main(String[] args) {

        // 방법 1 : ArrayList 타입을 선언
        ArrayList<String> list1 = new ArrayList<>();

        // 방법 2 : List 타입으로 선언
        List<String> list2 = new ArrayList<>();

        // 추가
        // 배열에서의 방법은: array[0] = "사과";
        list1.add("사과");    // 매개변수 한 개 짜리 add 메서드는 항상 마지막에 추가함. 지금은 index 0번.
        list1.add(1, "포도");     // 매개변수 두 개 짜리(오버로딩) add 메서드는 인덱스를 지정하여 추가함.

        // 조회
        list1.get(0);
        list1.size();               // 요소의 개수
        list1.contains("사과");       // 요소가 포함되어 있는지 확인. 요소의 .equals() 구현 메서드를 통해 판단.
        list1.indexOf("사과");        // 요소의 인덱스 반환. 없으면 -1을 반환.

        // 삭제
        list1.remove("사과");     // 값을 통해 요소를 삭제
        list1.remove(0);        // 인덱스를 통해 요소를 삭제
        list1.clear();                  // 전체 요소 삭제

        // 기타 유틸
        list1.isEmpty();            // 비어 있는지 확인


        // ※ 아래는 진도 외 개인 학습
        System.out.println("--------------------------------------");

        list2.add("벚꽃");
        list2.add("목련");
        list2.add("백합");

        // toString 구현 깔끔한거 확인(배열이랑은 너무 달라서 좋아)
        System.out.println(list2);

        // 각종 루프 돌리는 방법
        // 1. 향상된 for
        for (String item : list2) {
            System.out.print(item + "\t");
        }
        System.out.println();

        // 2. forEach 메서드
        list2.forEach(item -> System.out.print(item + "\t"));
        System.out.println();

        // 3. 이터레이터
        Iterator<String> iterator = list2.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.print(item + "\t");
            // 요소를 삭제할 때도 유용
        }
        System.out.println();

        // 4. 스트림 forEach : 필터링 등의 추가 연산에 유용
        list2.stream().forEach(item -> System.out.print(item + "\t"));
        System.out.println();

        // 정렬
        // 기본
        list2.sort(null);
        System.out.println(list2);

        // 사용자 정의: 글자 수
        //list2.sort((a, b) -> a.length() - b.length());


    }

}
