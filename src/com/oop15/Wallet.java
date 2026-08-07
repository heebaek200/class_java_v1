package com.oop15;

public class Wallet {
    private int money = 10000;

    // 지갑에서 돈을 모두 꺼내다.
    public int takeMoney() {
        int currentMoney = money;
        money = 0;
        return currentMoney;
    }
}
