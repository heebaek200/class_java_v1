package com.oop15;

public class LibraryMainTest {
    public static void main(String[] args) {
        // 1. 책 객체를 밖에서 생성 (독립적인 존재가 됨)
        Book b1 = new Book("자바의 정석");
        Book b2 = new Book("이펙티브 자바");

        // 2. 도서관을 만들고 책을 넣을 수 있다.
        Library library1 = new Library(5);
        library1.addBook(b1);
        library1.addBook(b2);
        library1.showBooks();

        System.out.println("----- 도서관 폐관해보기 -----");

        // 3. 도서관 객체 참조 끊기 (GC 수거 대상이 됨)
        library1 = null;

        // 4. 도서관은 사라졌지만, b1, b2는 살아있음.
        b1.display();
        b2.display();


    }
}
