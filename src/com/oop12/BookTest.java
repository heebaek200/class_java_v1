package com.oop12;

import java.util.Objects;

public class BookTest {

    public static void main(String[] args) {

        Book[] books = new Book[10];
        int i = 0;
        books[i++] = new Book("플러터UI실전", "김근호", 300);
        books[i++] = new Book("무궁화꽃이피었습니다", "김진명", 500);
        books[i++] = new Book("흐르는강물처럼", "파울로코엘료", 250);
        books[i++] = new Book("리딩으로리드하라", "이지성", 450);
        books[i++] = new Book("사피엔스", "유발하라리", 850);
        books[books.length-1] = new Book("홍길동전", "허균", 350);


        for (Book book: books) {
            // Null Pointer Exception 회피
            if (Objects.nonNull(book)) {
                System.out.println(book.getTitle() + ", " + book.getAuthor());
//                book.showInfo();
            }
        }

    }

}
