package useful.ch15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 단어장 예제
public class WordBook {
    private static Map<String, String> words = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    // 단어 추가
    public static void add(String k, String v) {
        words.put(k, v);

        System.out.println("다음 단어가 추가되었습니다 : " + k + " - " + v);
    }

    // 단어 검색
    public static String search(String k) {
        if (words.containsKey(k)) {
            // 검색된 경우

            String v = words.get(k);

            System.out.println("다음 단어가 검색 되었습니다 : " + k + " - " + v);

            return v;
        } else {
            // 검색되지 않은 경우
            System.out.println("해당 단어가 검색 되지 않았습니다 : " + k);

            return null;
        }
    }

    // 전체 출력
    public static void readAll() {
        System.out.println("전체 출력합니다. =====");

        for (String k : words.keySet()) {
            String v = words.get(k);

            System.out.println(k + " - " + v);
        }
    }

    public static void main(String[] args) {
        // 예를 들어 apple -> 사과 로 저장된 HashMap의 CRUD 구현 (객체지향 안쓰고)

        boolean flag = true;

        // 샘플 데이터
        words.put("apple", "사과");
        words.put("banana", "바나나");
        words.put("cherry", "체리");

        while (flag) {
            System.out.println("\n=== 영한 단어장 ===");
            System.out.println("1. 단어 추가 / 2. 단어 검색 / 3. 전체 출력 / 4. 종료");
            System.out.print("선택 : ");
            String choice = scanner.nextLine();

            // 아래 기능을 구현해 주세요.

            switch (choice) {
                case "1" -> {
                    // 단어 추가
                    System.out.println("추가할 영단어를 입력해주세요 : ");
                    String k = scanner.nextLine();

                    System.out.println("그 뜻인 한국어 단어를 입력해주세요 : ");
                    String v = scanner.nextLine();

                    add(k, v);
                }
                case "2" -> {
                    // 단어 검색
                    System.out.println("검색할 영단어를 입력해주세요 : ");
                    String k = scanner.nextLine();

                    search(k);
                }
                case "3" -> {
                    // 전체 출력
                    readAll();
                }
                case "4" -> {
                    // 종료
                    System.out.println("프로그램을 종료합니다.");
                    flag = false;
                }
                default -> {
                    System.out.println("잘못된 값을 입력했습니다. 메뉴의 번호를 입력해주세요.");
                }
            }

            if (!flag) {
                break;
            }
        }


        scanner.close();

    }

}
