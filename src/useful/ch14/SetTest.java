package useful.ch14;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {

        // 순서 없고, 중복 불가한 컬렉션
        Set<String> set = new HashSet<>();

        // 추가
        set.add("철수");
        set.add("영희");
        set.add("철수");
        System.out.println(set);
        System.out.println(set.toString());
        System.out.println(set.size());

        // 포함 여부
        System.out.println(set.contains("철수"));
        System.out.println(set.contains("민준"));

        // 삭제
        set.remove("철수");

        // 전체 순회
        // 방법 1
        for (String u : set) {
            System.out.println(u);
        }


    } // end of main

}
