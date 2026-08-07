package com.oop12;

import java.util.Scanner;

/**
 * 모든 프로그래밍의 기본은 Create Read Update Delete 이다.
 * 배열을 활용한 간단한 데이터 관리 시스템
 */
public class MyBookStore {

    // 현재 저장된 실제 데이터 개수를 추적하는 공유 변수 (static)
    private static int lastIndexNumber = 0;


    public static final String SAVE = "1";
    public static final String SEARCH_ALL = "2";
    public static final String SEARCH_BY_TITLE = "3";
    public static final String DELETE_ALL = "4";
    public static final String DELETE_BY_TITLE = "5";
    public static final String END = "0";
    public static final String MENU_MSG = "1. 저장 2. 전체조회 3. 선택조회 4. 전체삭제 5. 선택삭제 0. 종료";


    // 저장 기능(C)
    public static void save(Scanner scanner, Book[] books) {

        if (lastIndexNumber >= books.length) {
            System.out.println("저장 공간이 가득 찼습니다.");
            return;
        }

        System.out.println("제목을 입력해주세요: ");
        String title = scanner.nextLine();
        System.out.println("저자를 입력해주세요: ");
        String author = scanner.nextLine();

        Book book = new Book(title, author);
        books[lastIndexNumber++] = book;

        System.out.println("------ 다음 책 정보가 저장되었습니다.");
        book.showInfo();
    }

    // 전체 조회 기능(R)
    public static void readAll(Book[] books) {

        if (lastIndexNumber == 0) {
            System.out.println("저장된 책 정보가 없습니다.");
            return;
        }

        for (Book book : books) {
            if (book != null) {
                System.out.println(">> " + book.getTitle() + ", " + book.getAuthor());
            }
        }
    }

    // 선택 조회 기능
    public static void searchByTitle(Scanner scanner, Book[] books) {
        System.out.println("조회할 책 제목을 입력해주세요");
        String targetTitle = scanner.nextLine().trim();
        Book targetBook = null;

        for (Book book : books) {
            if (book != null) {
                if (book.getTitle().equals(targetTitle)) {
                    targetBook = book;
                    break;
                }
            }
        }

        if (targetBook != null) {
            // 검색한 경우
            System.out.println(">> " + targetBook.getTitle() + ", " + targetBook.getAuthor());
        } else {
            // 검색하지 못한 경우
            System.out.println(">> 조회된 책이 없습니다.");
        }

    }

    // 수정 기능(U)
    public static void update(Scanner scanner, Book[] books) {
        System.out.println("수정할 책 제목을 입력해주세요");
        String targetTitle = scanner.nextLine().trim();
        ;
        Book targetBook = null;

        for (Book book : books) {
            if (book != null) {
                if (book.getTitle().equals(targetTitle)) {
                    targetBook = book;
                    break;
                }
            }
        }

        if (targetBook != null) {
            // 조회한 경우

            System.out.println("수정할 제목을 입력해주세요: ");
            String title = scanner.nextLine();
            System.out.println("수정할 저자를 입력해주세요: ");
            String author = scanner.nextLine();

            targetBook.setTitle(title);
            targetBook.setAuthor(author);

            System.out.println("------ 다음 책 정보가 저장되었습니다.");
            targetBook.showInfo();
        } else {
            // 조회하지 못한 경우
            System.out.println(">> 조회된 책이 없습니다.");
        }

    }

    // 전체 삭제 기능(D)
    public static void deleteAll(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            books[i] = null;
        }
        lastIndexNumber = 0;

        System.out.println("※ 전체 삭제되었습니다.");
    }

    // 선택 삭제 기능
    public static void deleteByTitle(Scanner scanner, Book[] books) {
        System.out.println("삭제할 책 제목을 입력해주세요");
        String targetTitle = scanner.nextLine().trim();

        Book targetBook = null;
        int targetIndex = -1;

        for (int i = 0 ; i < books.length ; i++) {
            Book book = books[i];
            if (book != null) {
                if (book.getTitle().equals(targetTitle)) {
                    targetBook = book;
                    targetIndex = i;
                    break;
                }
            }
        }

        if (targetBook != null) {
            // 조회한 경우
            books[targetIndex] = null;

            // 한 칸 씩 당기기
            for (int i = targetIndex + 1 ; i < books.length ; i++) {
                books[i-1] = books[i];
            }

            lastIndexNumber--;
            System.out.println("책 정보가 삭제되었습니다.");
        } else {
            // 조회하지 못한 경우
            System.out.println(">> 조회된 책이 없습니다.");
        }
    }


    public static void main(String[] args) {
        // 준비물
        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[100];
        boolean flag = true;

        // 샘플 데이터
        int ib = 0;
        books[ib++] = new Book("플러터UI실전", "김근호");
        books[ib++] = new Book("무궁화꽃이피었습니다", "김진명");
        books[ib++] = new Book("흐르는강물처럼", "파울로코엘료");
        books[ib++] = new Book("리딩으로리드하라", "이지성");
        books[ib++] = new Book("사피엔스", "유발하라리");
        lastIndexNumber = ib - 1;

        // 실행의 흐름
        while (flag) {
            System.out.println("** 메뉴 선택 **");
            System.out.println(MENU_MSG);

            String seletedNumber = scanner.nextLine();
            switch (seletedNumber) {
                case SAVE -> {
                    System.out.println(">> 「저장하기」를 실행합니다.");

                    save(scanner, books);
                }
                case SEARCH_ALL -> {
                    System.out.println(">> 「전체조회」를 실행합니다.");

                    readAll(books);
                }
                case SEARCH_BY_TITLE -> {
                    System.out.println(">> 「선택조회」를 실행합니다.");

                    searchByTitle(scanner, books);
                }
                case DELETE_ALL -> {
                    System.out.println(">> 「전체삭제」를 실행합니다.");

                    deleteAll(books);
                }
                case DELETE_BY_TITLE -> {
                    System.out.println(">> 「선택삭제」를 실행합니다.");

                    deleteByTitle(scanner, books);
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
