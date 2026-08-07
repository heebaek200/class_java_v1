package practice.managephonenumber;

import java.util.Scanner;

// 코드 실행 클래스
public class Manager {

    // 메뉴 요소
    public static final String READ_ALL         = "1";
    public static final String READ_BY_NAME     = "2";
    public static final String CREATE           = "3";
    public static final String UPDATE_BY_NAME   = "4";
    public static final String DELETE_ALL       = "5";
    public static final String DELETE_BY_NAME   = "6";
    public static final String END              = "0";
    public static final String MENU_MSG         = "1. 전체조회 2. 선택조회 3. 신규추가 4. 선택수정 5. 전체삭제 6. 선택삭제 0. 종료";

    // 전화번호부
    private static PhoneBook phoneBook = new PhoneBook();

    // 스캐너
    private static Scanner scanner = new Scanner(System.in);

    // 전체조회
    public static void readAll() {
        System.out.println(">> 「전체조회」 메뉴를 선택했습니다.");
        System.out.println("..............");

        System.out.println(">> 전화번호부 전체를 조회합니다.");
        System.out.println("..............");
        int size = phoneBook.readAll();

        if (size == 0) {
            System.out.println(">> 등록된 전화번호가 존재하지 않습니다.");
        }
    }

    // 선택조회
    public static void readByName() {
        System.out.println(">> 「선택조회」 메뉴를 선택했습니다.");
        System.out.println("..............");

        System.out.println("조회할 '이름'을 입력해주세요:");
        String entryName = scanner.nextLine();

        PhoneBookEntry target = phoneBook.getEntryByName(entryName);
        if (target != null) {
            // 조회
            System.out.println(">> 조회에 성공했습니다.");
            target.showInfo();
        } else {
            // 실패
            System.out.println(">> 😥해당하는 이름의 전화번호를 찾을 수 없습니다...");
        }
    }

    // 신규추가
    public static void create() {
        System.out.println(">> 「신규추가」 메뉴를 선택했습니다.");
        System.out.println("..............");

        // 최대치 초과했는지 확인
        if (!phoneBook.checkSpace()) {
            System.out.println(">> ⁉️⁉️전화번호 레코드가 최대치를 초과하여 추가 등록할 수 없습니다..");
            return;
        }

        System.out.println("'이름'을 입력해주세요:");
        String entryName = scanner.nextLine();
        System.out.println("'전화번호'를 입력해주세요:");
        String phoneNumber = scanner.nextLine();

        System.out.println(">> 전화번호 레코드를 등록합니다.");
        System.out.println("..............");

        PhoneBookEntry newPhoneBookEntry = phoneBook.create(entryName, phoneNumber);

        System.out.println(">> 다음 전화번호 레코드 등록을 완료했습니다.");
        newPhoneBookEntry.showInfo();
    }

    // 선택수정
    public static void updateByName() {
        System.out.println(">> 「선택수정」 메뉴를 선택했습니다.");
        System.out.println("..............");

        System.out.println("수정할 '이름'을 입력해주세요:");
        String entryName = scanner.nextLine();

        PhoneBookEntry target = phoneBook.getEntryByName(entryName);
        if (target != null) {
            // 조회
            System.out.println("'이름'을 입력해주세요:");
            String newEntryName = scanner.nextLine();
            System.out.println("'전화번호'를 입력해주세요:");
            String newPhoneNumber = scanner.nextLine();

            target.update(newEntryName, newPhoneNumber);

            System.out.println(">> 다음 전화번호 레코드 수정을 완료했습니다.");
            target.showInfo();
        } else {
            // 실패
            System.out.println(">> 😥해당하는 이름의 전화번호를 찾을 수 없습니다...");
        }
    }

    // 전체삭제
    public static void deleteAll() {
        System.out.println(">> 「전체삭제」 메뉴를 선택했습니다.");
        System.out.println("..............");

        System.out.println("!!!!! 정말 삭제하시겠습니까? (Y/N):");
        String lastAnswer = scanner.nextLine();
        if (lastAnswer.equals("Y")) {
            System.out.println(">> 전화번호부 전체를 삭제합니다.");
            System.out.println("..............");

            phoneBook.deleteAll();

            System.out.println(">> 전화번호 레코드를 모두 삭제 완료했습니다.");
        } else {
            System.out.println(">> 「전체삭제」를 중단합니다.");
        }
    }

    // 선택삭제
    public static void deleteByName() {
        System.out.println(">> 「선택삭제」 메뉴를 선택했습니다.");
        System.out.println("..............");

        System.out.println("삭제할 '이름'을 입력해주세요:");
        String entryName = scanner.nextLine();

        PhoneBookEntry target = phoneBook.getEntryByName(entryName);
        if (target != null) {
            // 조회
            System.out.println(">> 해당 전화번호를 삭제합니다.");
            System.out.println("..............");

            phoneBook.deleteOne(target);

            System.out.println(">> 해당 전화번호를 삭제 완료했습니다.");
        } else {
            // 실패
            System.out.println(">> 😥해당하는 이름의 전화번호를 찾을 수 없습니다...");
        }
    }


    // 코드 실행점
    public static void main(String[] args) {

        // 메뉴 입력 시작
        boolean flag = true;
        while (flag) {
            System.out.println();
            System.out.println();
            System.out.println("** 메뉴 선택 **");
            System.out.println(MENU_MSG);
            
            // 메뉴 선택을 입력받는다.
            String seletedNumber = scanner.nextLine();

            var a = 1;
            
            switch (seletedNumber) {
                case READ_ALL -> {
                    readAll();
                }
                case READ_BY_NAME -> {
                    readByName();
                }
                case CREATE -> {
                    create();
                }
                case UPDATE_BY_NAME -> {
                    updateByName();
                }
                case DELETE_ALL -> {
                    deleteAll();
                }
                case DELETE_BY_NAME -> {
                    deleteByName();
                }
                case END -> {
                    System.out.println(">> 프로그램을 종료합니다.");
                    flag = false;
                }
                default -> {
                    System.out.println(">> 메뉴에 없는 항목을 선택했습니다.");
                }


            }
            
        }

        scanner.close();
    } // end of main

}
