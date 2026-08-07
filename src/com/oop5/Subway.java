package com.oop5;

public class Subway extends Vehicle {

    private int lineNumber;     // 호선
    //private int count;          // 승객수
    //private int money;          // 수익금

    // 생성자
    public Subway(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    // 정보보기
    public void showInfo() {
        System.out.println("지하철 노선: " + getLineNumber());
        System.out.println("현재 승객 수:" + getCount());
        System.out.println("현재 수익 금액: " + getMoney());
    }

    // getter, setter
    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }
}
