package ch08;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 도전 과제. 코드 추가 및 수정
 * 프로그램 종료 시 사용자가 메뉴를 누른 횟수를 출력
 */
public class MenuChoice2 {
    // 메뉴 번호를 고정 상수로 선언 (명칭은 CRUD 개념 적용)
    public static final int MENU_CREATE = 1;
    public static final int MENU_READ   = 2;
    public static final int MENU_UPDATE = 3;
    public static final int MENU_DELETE = 4;
    public static final int MENU_EXIT   = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Map에 유효한 메뉴 등록
        Map<Integer, String> menuMap = new LinkedHashMap<>();
        menuMap.put(MENU_CREATE, "등록");
        menuMap.put(MENU_READ  , "조회");
        menuMap.put(MENU_UPDATE, "수정");
        menuMap.put(MENU_DELETE, "삭제");
        menuMap.put(MENU_EXIT  , "종료");

        // 메뉴 선택지 문자열 작성
        StringBuilder menuPrompt = new StringBuilder();
        for (Map.Entry<Integer, String> entry : menuMap.entrySet()) {
            menuPrompt.append(entry.getKey()).append(".").append(entry.getValue()).append(" ");
        }
        menuPrompt.append(": ");

        // 실행 횟수
        int count = 0;

        while (true) {
            System.out.println("\n--- 메뉴를 선택하세요 ---");
            System.out.print(menuPrompt.toString());

            // 숫자 입력 확인
            if (!scanner.hasNextInt()) {
                System.out.println("❌ 숫자만 입력 가능합니다.");
                scanner.next(); // 입력 버리기
                continue;
            }

            int input = scanner.nextInt();

            // Map을 사용하여 유효한 입력인지 판단
            if (!menuMap.containsKey(input)) {
                System.out.println("❌ 잘못된 입력입니다. 다시 선택해주세요.");
                continue;
            }

            // 유효한 입력 처리
            String selectedMenu = menuMap.get(input);
            System.out.println("▶ [" + selectedMenu + "] 기능을 선택하셨습니다.");

            // 실제 로직
            switch (input) {
                case MENU_CREATE:
                case MENU_READ:
                case MENU_UPDATE:
                case MENU_DELETE:
                    count ++;
                    System.out.println("▶ [" + selectedMenu + "] 기능을 실행합니다...");
                    break;
            }

            // 프로그램 종료
            if (input == MENU_EXIT) {
                System.out.println("프로그램을 종료합니다.");
                System.out.println("프로그램 동작 중 기능을 총 " + count + "번 실행하셨습니다.");
                break;
            }


        }
        scanner.close();

    }
}
