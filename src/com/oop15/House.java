package com.oop15;

public class House {

    private String address;

    // 합성 관계: House는 내부에 Room 객체들을 가진다.
    private Room livingRoom;
    private Room bedRoom;


    public House(String address) {
        this.address = address;

        // 합성 조건1: 생성자에서 객체 생성
        this.livingRoom = new Room("거실");
        this.bedRoom = new Room("침실");
    }

    // 합성 조건2: Room에 대한 getter를 만들지 않는다

    public void showInfo() {
        System.out.println(address + " 방에 위치한 집입니다.");
        livingRoom.use();
        bedRoom.use();
    }


}
