package useful.ch15;

import java.util.HashMap;
import java.util.Map;

public class ScoreHashMap {

    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();

        // 추가 (put)
        scores.put("철수", 90);
        scores.put("영희", 85);
        scores.put("민준", 92);
        scores.put("철수", 100);      // 중복 시 덮어쓰기
        System.out.println(scores);
        System.out.println("--------------------------------");

        // 조회 (get)
        System.out.println(scores.get("철수"));
        System.out.println(scores.get("없는키"));

        // 포함 여부
        System.out.println(scores.containsKey("철수"));         // 키 기준
        System.out.println(scores.containsValue(85));           // 밸류 기준

        // 삭제
        System.out.println("------------------------------");
        int removedResult = scores.remove("철수");
        System.out.println(removedResult);
        System.out.println(scores);

        // 크기 확인
        System.out.println("크기 : " + scores.size());

        // 순회
        for (String k : scores.keySet()) {
            System.out.println(k + " : " + scores.get(k) + " 점");
        }

    }

}
