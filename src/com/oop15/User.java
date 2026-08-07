package com.oop15;

public class User {

    private int id;
    private String name;

    // 연관관계: User는 todo 객체의 주소값을 담을 수 있는 참조변수를 가진다.
    private Todo todo;

    public User(int id, String name) {
        this.id = id;
        this.name = name;

        // todo(참조 타입 필드 멤버)는 초기화하지 않았으므로 기본값 null 상태이다.

    }


    // 할 일을 할당받는 메서드 (연관 관계 형성)
    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    public void displayMyTask() {
        System.out.println(id + " 번 " + name + " 님의 현재 할 일 정보입니다.");
        if (todo == null) {
            System.out.println("현재 등록된 할 일이 없습니다.");
        } else {
            // 연관된 todo 객체의 메서드를 호출한다.
            todo.showInfo();
        }
    }



}
