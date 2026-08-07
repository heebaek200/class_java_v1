package ch08;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 변수 name을 사용해서 CRUD 구현
 */
public class MenuChoice5 {

    // CRUD를 전담하는 내부 클래스
    public static class MemberService {
        private String name = "";
        private Scanner scanner = null;

        MemberService (Scanner scanner) {
            this.scanner = scanner;
        }

        // 등록된 유저가 존재하는지 체크
        public boolean hasMember () {
            if (name.equals("")) {
                return false;
            } else {
                return true;
            }
        }

        // 등록
        public String createMember () {
            if (hasMember()) {
                System.out.println("이미 등록된 이름이 존재합니다.");
            } else {
                System.out.println("이름을 입력해 주세요. ▶");
                name = scanner.nextLine();
                System.out.println("이름이 등록되었습니다. ▶" + name);
            }

            return name;
        }

        // 조회
        public String readMember () {
            if (hasMember()) {
                System.out.println("등록된 이름은 다음과 같습니다. ▶" + name);
            } else {
                System.out.println("등록된 이름이 없습니다.");
            }

            return this.name;
        }

        // 수정
        public String updateMember () {
            if (hasMember()) {
                System.out.println("이름을 입력해 주세요. ▶");
                name = scanner.nextLine();
                System.out.println("이름이 수정되었습니다. ▶" + name);
            } else {
                System.out.println("등록된 이름이 없습니다.");
            }

            return name;
        }

        // 삭제
        public String deleteMember () {
            String prevName = this.name;

            if (hasMember()) {
                System.out.println("등록된 이름을 삭제합니다.");
                this.name = "";
            } else {
                System.out.println("등록된 이름이 없습니다.");
            }

            return prevName;
        }
    }

    // 메뉴 관리를 전담하는 내부 클래스 (Static Class)
    public static class MenuProcessor {

        // 메뉴 번호를 고정 상수로 선언 (명칭은 CRUD 개념 적용)
        public static final int MENU_CREATE = 1;
        public static final int MENU_READ   = 2;
        public static final int MENU_UPDATE = 3;
        public static final int MENU_DELETE = 4;
        public static final int MENU_EXIT   = 0;

        private static final Map<Integer, String> menuMap = new LinkedHashMap<>();
        private static final String menuPrompt;

        // 클래스 로딩 시점에 메뉴 데이터와 가이드 문구 초기화
        static {
            // Map에 유효한 메뉴 등록
            menuMap.put(MENU_CREATE, "등록");
            menuMap.put(MENU_READ,   "조회");
            menuMap.put(MENU_UPDATE, "수정");
            menuMap.put(MENU_DELETE, "삭제");
            menuMap.put(MENU_EXIT,   "종료");

            // 메뉴 선택지 문자열 작성
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, String> entry : menuMap.entrySet()) {
                sb.append(entry.getKey()).append(".").append(entry.getValue()).append(" ");
            }
            sb.append(": ");
            menuPrompt = sb.toString();
        }

        // 가이드 메시지 반환
        public static String getMenuPrompt() {
            return menuPrompt;
        }

        // 유효한 메뉴인지 검증
        public static boolean isValidMenu(int code) {
            return menuMap.containsKey(code);
        }

        // 메뉴 이름 반환
        public static String getMenuName(int code) {
            return menuMap.get(code);
        }
    }



    // main
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 잘못된 입력 횟수 커스텀 예외 클래스
        class WrongCountException extends RuntimeException {
            public WrongCountException(String message) {
                super(message);
            }
        }
        // 잘못된 입력 횟수
        // 단, 3회 이전에 정상 메뉴 눌렀다면 0으로 초기화되어야 한다.
        int wrongCount = 0;

        // CRUD 클래스
        MemberService memberService = new MemberService(scanner);

        try {
            while (true) {
                // 잘못된 입력을 3번 이상 입력 시 강제 종료
                if (wrongCount >= 3) {
                    throw new WrongCountException("");
                }

                System.out.println("\n--- 메뉴를 선택하세요 ---");
                System.out.print(MenuProcessor.getMenuPrompt());

                // 숫자 입력 확인
                if (!scanner.hasNextInt()) {
                    System.out.println("❌ 숫자만 입력 가능합니다.");
                    scanner.next(); // 입력 버리기
                    wrongCount++;
                    continue;
                }

                int input = scanner.nextInt();
                scanner.nextLine(); // 개행 패스

                // Map을 사용하여 유효한 입력인지 판단
                if (!MenuProcessor.isValidMenu(input)) {
                    System.out.println("❌ 잘못된 입력입니다. 다시 선택해주세요.");
                    wrongCount++;
                    continue;
                }

                // 유효한 입력 처리
                String selectedMenu = MenuProcessor.getMenuName(input);
                System.out.println("▶ [" + selectedMenu + "] 기능을 선택하셨습니다.");

                // 실제 로직
                switch (input) {
                    case MenuProcessor.MENU_CREATE:
                        // name 변수에 스캐너를 사용하여 이름을 등록하는 기능을 구현
                        System.out.println("▶ [" + selectedMenu + "] 기능을 실행합니다...");
                        wrongCount = 0;

                        // 이름 입력
                        memberService.createMember();
                        break;
                    case MenuProcessor.MENU_READ:
                        // name을 출력하는 기능 구현
                        System.out.println("▶ [" + selectedMenu + "] 기능을 실행합니다...");
                        wrongCount = 0;

                        // 조회
                        memberService.readMember();
                        break;
                    case MenuProcessor.MENU_UPDATE:
                        // name을 수정하는 기능 구현
                        System.out.println("▶ [" + selectedMenu + "] 기능을 실행합니다...");
                        wrongCount = 0;

                        // 이름 입력
                        memberService.updateMember();
                        break;
                    case MenuProcessor.MENU_DELETE:
                        // name을 삭제하는 기능 구현
                        System.out.println("▶ [" + selectedMenu + "] 기능을 실행합니다...");
                        wrongCount = 0;

                        memberService.deleteMember();
                        break;
                }

                // 프로그램 종료
                if (input == MenuProcessor.MENU_EXIT) {
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
