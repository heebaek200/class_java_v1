package com.oop12;

public class Book {

    // 제목
    private String title;
    // 저자
    private String author;
    // 책의 쪽 수
    private int totalPage;

    // 생성자 (제목, 저자 입력. 쪽 수는 0으로 초기화)
    public Book(String title, String author) {
        this(title, author, 0);
    }

    // 생성자 (제목, 저자 입력. 쪽 수 입력)
    public Book(String title, String author, int totalPage) {
        this.title = title.trim();
        this.author = author.trim();
        this.totalPage = totalPage;
    }

    // 제목 getter
    public String getTitle() {
        return title;
    }

    // 저자 getter
    public String getAuthor() {
        return author;
    }

    // 쪽 수 getter
    public int getTotalPage() {
        return totalPage;
    }

    // 제목 setter
    public void setTitle(String title) {
        this.title = title.trim();
    }

    // 저자 setter
    public void setAuthor(String author) {
        this.author = author.trim();
    }

    // 쪽 수 setter
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void showInfo() {
        System.out.println("＊＊＊＊＊　책　정보　＊＊＊＊＊");
        System.out.println(" 제목: "  + title);
        System.out.println(" 저자: "  + author);
        if (totalPage != 0) {
            System.out.println(" 쪽 수: " + totalPage);
        }
        System.out.println("＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊＊");
    }
}
