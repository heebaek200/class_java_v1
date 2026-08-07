package com.oop20;

public class RemoteControlMain {

    public static void main(String[] args) {

        // 인터페이스 타입으로 객체를 받을 수 있습니다.
        RemoteControl rc = new TV();        // 업캐스팅
        rc.turnON();
        rc.setMaxVolume(15);
        rc.turnOFF();

        System.out.println("---------------------------------");
        rc = new Audio();
        rc.turnON();
        rc.setMaxVolume(5);
        rc.turnOFF();



    } // end of main

}
