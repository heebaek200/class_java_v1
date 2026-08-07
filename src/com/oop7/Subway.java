package com.oop7;

public class Subway implements Rideable {

    private int lineNumber;
    private int price;
    private int count;      // 승객
    private int money;      // 매출

    public Subway(int lineNumber, int price) {
        this.lineNumber = lineNumber;
        this.price = price;
    }

    @Override
    public int ride(int pay) {
        if (pay >= price) {
            this.money += price;
            this.count++;

            System.out.println("지하철에 탑승하였습니다.");
            return pay - price;
        } else {

            System.out.println("지하철에 탑승하지 못했습니다. 잔액 : " + pay);
            return pay;
        }
    }
}
