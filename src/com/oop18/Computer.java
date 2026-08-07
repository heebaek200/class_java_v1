package com.oop18;

public abstract class Computer {

    // abstract methods
    public abstract void display();
    public abstract void typing();

    public void turnOn() {
        System.out.println("컴퓨터 전원 ON!");
    }

    public void turnOff() {
        System.out.println("컴퓨터 전원 OFF!");
    }


}
