package com.oop6;

public class Account {

    private String name;
    private int balance;

    // 입금하다
    public void deposit(int money) {
        balance += money;
        System.out.println("입금 완료. " + money + "원을 입금하여 잔고 " + balance);
    }

    // 출금하다
    public int withdraw(int money) {
        if (balance >= money) {
            balance -= money;
            System.out.println("출금 완료. " + money + "원을 출금하여 잔고 " + balance);

            return money;
        } else {
            System.out.println("잔액 부족. " + money + "원을 출금할 수 없습니다.");

            return 0;
        }
    }

    // 현재 잔액 표시
    public int showInfo() {
        System.out.println("현재 잔액: " + balance + "원");

        return balance;
    }

}
