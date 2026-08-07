package com.oop8;

public class PersonTest {
    public static void main(String[] args) {

        Person person1 = new Person("이희백", 38, "010-xxxx-yyyy", "M");

        person1.setName("홍길동");
        person1.setAge(39);
        person1.setPhone("019-1234-2343");

        person1.setName("홍길동").setAge(39).setPhone("019-1234-2343");


    }

}
