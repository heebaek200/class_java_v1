package com.oop1;

public class BookMainTest1 {

    public static void main(String[] args) {

        Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();

        System.out.println("book1 : " + book1);
        System.out.println("book2 : " + book2);
        System.out.println("book3 : " + book3);

        // new 키워드를 3번 사용했기 때문에 Heap 메모리 영역에 객체가 3개 생성되었다.
        // 즉, 메모리에 올라가면(=인스턴스화) 객체라고 부른다.



    }

}
