package com.oop4;

public class Bus {

    int busNumber;
    int money;

    // Overloaded Constructor 1
    public Bus(int n) {
        busNumber = n;
    }

    // Overloaded Constructor 2 - 생성자 오버로딩
    public Bus(int n, int m) {
        busNumber = n;
        money = m;
    }

}
