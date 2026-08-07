package com.oop3;

// 버스 클래스 설계(속성과 행위

public class Bus {

    private String vehicleNumber;   // 차량번호
    private int maxCapacity;        // 최대 수용 인원
    private int currentPassengers;  // 현재 승객 수

    public Bus() {
        currentPassengers = 0;
    }

    // 차량번호 getter
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    // 차량번호 setter
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    // 최대 수용 인원 getter
    public int getMaxCapacity() {
        return maxCapacity;
    }

    // 최대 수용 인원 setter
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    // 현재 승객수 반환
    public int getCurrentPassengers() {
        return currentPassengers;
    }

    // 승객 승차
    public int boardPessenger(int count) {
        return currentPassengers += count;
    }

    // 승객 하차
    public int alightPassenger(int count) {
        return currentPassengers -= count;
    }

    // 정지
    public void stop() {
        System.out.println("버스가 정차합니다");
    }

    public void start() {
        System.out.println("버스가 출발합니다.");
    }
}
