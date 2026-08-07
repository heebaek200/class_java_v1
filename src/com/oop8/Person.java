package com.oop8;

public class Person {

    // this 키워드의 3가지 활용 방법
    // 1. 자기 자신의 주소를 가르킨다
    // 2. 생성자에서 다른 생성자를 호출할 수 있다
    // 3. 자기 자신의 주소값을 return 값으로 반환시킬 수 있다


    // 멤버 변수 (필드)
    private String name;
    private int age;
    private String phone;
    private String gender; // F, M


    // 생성자1 - this 사용방법1
    public Person(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    // 생성자2 - this 사용방법2
    public Person(String name, int age, String phone) {
        //this.name  = name;
        //this.age   = age;
        this(name, age);

        this.phone = phone;
    }

    // 생성자3
    public Person(String name, int age, String phone, String gender) {
        this(name, age, phone);

        this.gender = gender;
    }

    // 메서드(자신을 반환하는 형태) - this 사용방법3
    public Person getPerson() {
        return this;
    }

    public Person setName(String name) {
        this.name = name;

        return this;
    }

    public Person setAge(int age) {
        this.age = age;

        return this;
    }

    public Person setPhone(String phone) {
        this.phone = phone;

        return this;
    }

    public Person setGender(String gender) {
        this.gender = gender;

        return this;
    }

} // end of class
