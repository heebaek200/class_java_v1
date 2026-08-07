package com.oop18;

public class Person extends Human {

    @Override
    public void hunt() {
        System.out.println("문제해결기(물리)로 사냥합니다.");
    }

    public static void main(String[] args) {
        Animal animal = new Person();
        animal.hunt();
    }
}
