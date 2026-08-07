package com.oop3;

public class BusMainTest1 {

    public static void main(String[] args) {
        Bus bus = new Bus();


        bus.stop();
        bus.boardPessenger(5);
        System.out.println("현재 승객 수: " + bus.getCurrentPassengers());

        bus.start();
    }

}
