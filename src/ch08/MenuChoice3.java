package ch08;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 3. 잘못된 입력을 3번 이상 입력 시 강제 종료
 * 단, 3회 이전에 정상 메뉴 눌렀다면 0으로 초기화되어야 한다.
 */
public class MenuChoice3 {
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

        // 잘못된 입력 횟수 커스텀 예외 클래스
        class WrongCountException extends RuntimeException {
            public WrongCountException(String message) {
                super(message);
            }
        }
        // 잘못된 입력 횟수
        // 단, 3회 이전에 정상 메뉴 눌렀다면 0으로 초기화되어야 한다.
        int wrongCount = 0;

        // 메뉴 선택지 문자열 작성
        StringBuilder menuPrompt = new StringBuilder();
        for (Map.Entry<Integer, String> entry : menuMap.entrySet()) {
            menuPrompt.append(entry.getKey()).append(".").append(entry.getValue()).append(" ");
        }
        menuPrompt.append(": ");

        try {
            while (true) {
                // 잘못된 입력을 3번 이상 입력 시 강제 종료
                if (wrongCount >= 3) {
                    throw new WrongCountException("");
                }

                System.out.println("\n--- 메뉴를 선택하세요 ---");
                System.out.print(menuPrompt.toString());

                // 숫자 입력 확인
                if (!scanner.hasNextInt()) {
                    System.out.println("❌ 숫자만 입력 가능합니다.");
                    scanner.next(); // 입력 버리기
                    wrongCount++;
                    continue;
                }

                int input = scanner.nextInt();

                // Map을 사용하여 유효한 입력인지 판단
                if (!menuMap.containsKey(input)) {
                    System.out.println("❌ 잘못된 입력입니다. 다시 선택해주세요.");
                    wrongCount++;
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
                        System.out.println("▶ [" + selectedMenu + "] 기능을 실행합니다...");
                        wrongCount = 0;
                        break;
                }

                // 프로그램 종료
                if (input == MENU_EXIT) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }


            }
        } catch (WrongCountException e) {
            System.out.println("******************************************");
            System.out.println("잘못된 입력이 3회 이상 입력되어 프로그램을 종료합니다.");

        }

        // 스캐너 종료
        scanner.close();
    }
}
