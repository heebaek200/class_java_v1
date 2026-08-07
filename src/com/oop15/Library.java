package com.oop15;

public class Library {

    private Book[] books;
    private int bookCount;

    public Library(int size) {
        books = new Book[size];

        this.bookCount = 0;
    }

    // 집합 관계의 핵심: 밖에서 생성된 객체의 주소값을 받아온다.
    public void addBook(Book book) {
        if (bookCount >= books.length) {
            System.out.println("더 이상 책을 넣을 공간이 없습니다.");
            return;
        }

        books[bookCount] = book;
        bookCount++;
    }

    public void showBooks() {
        // 배열의 길이가 아니라 실제 담긴 개수까지만 순회
        for (int i = 0; i < bookCount; i++) {
            books[i].display();
        }
    }


}
