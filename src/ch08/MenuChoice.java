package ch08;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 //- 사용자에게 다음 옵션을 보여주고 선택하도록 요청합니다
 //    “1.등록 2.조회 3.수정 4.삭제 0.종료”
 //- 사용자가 옵션 번호를 입력하면, 해당 옵션에 대한 메시지를 출력합니다. 예를 들어, 사용자가 '1'을 선택하면 "등록을 선택했습니다."라고 출력합니다.
 //- 사용자가 '0'을 선택하면 "프로그램을 종료합니다."라는 메시지를 출력하고 프로그램을 종료합니다.
 //- 사용자가 유효하지 않은 번호를 입력하면 "잘못된 입력입니다. 다시 선택해주세요."라고 안내하고 다시 메뉴 선택을 할 수 있도록 합니다.
 //- Scanner, while 그리고 if 구문을 활용해서 프로그램을 완성하세요.
 */
public class MenuChoice {
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

        StringBuilder menuPrompt = new StringBuilder();
        for (Map.Entry<Integer, String> entry : menuMap.entrySet()) {
            menuPrompt.append(entry.getKey()).append(".").append(entry.getValue()).append(" ");
        }
        menuPrompt.append(": ");

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
            System.out.println("▶ [" + selectedMenu + "] 기능을 실행합니다...");

            // 프로그램 종료
            if (input == MENU_EXIT) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }


        }
        scanner.close();

    }
}
