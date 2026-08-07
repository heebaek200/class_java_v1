package com.oop15;

public class Buyer {

    // 지갑(Wallet)을 필드로 가지지 않고, 메서드를 통해 잠시 사용함
    public void payMoney(Wallet wallet) {
        int money = wallet.takeMoney();
        System.out.println(money + " 원으로 결제합니다.");
    }

}
