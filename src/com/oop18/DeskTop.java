package com.oop18;

public class DeskTop extends Computer {

    @Override
    public void display() {
        System.out.println("데스크탑 화면을 표시합니다.");
    }

    @Override
    public void typing() {
        System.out.println("데스크탑에 타이핑합니다.");
    }
}
