package com.oop8;

public class Book {

    private String title;
    private String author;
    private int price;

    public Book(String title) {
        this(title, "미상");
        System.out.println("1번 생성자 호출됨");
    }
    public Book(String title, String author) {
        this(title, author, 0);
        System.out.println("2번 생성자 호출됨");
    }
    public Book(String title, String author, int price) {
        this.title  = title;
        this.author = author;
        this.price  = price;
        System.out.println("3번 생성자 호출됨");
    }

    // 메서드 체이닝 가능한 setters (this 반환)

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Book setPrice(int price) {
        this.price = price;
        return this;
    }
}
