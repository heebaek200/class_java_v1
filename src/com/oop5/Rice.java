package com.oop5;

public class Rice {

    // 필드
    private String menu;    // 현미밥, 잡곡밥
    private int amount;     // 양

    public Rice(String menu, int amount) {
        this.menu = menu;
        this.amount = amount;
    }

    // 먹은만큼 줄어든다. 성공하면 true, 실패하면 false 반환
    public boolean eat() {
        if (amount > 0) {
            amount--;
            return true;
        }

        return false;
    }

    public void showInfo() {
        System.out.println(this.menu + "의 현재 남은 양: " + amount);
    }


    // getter, setter
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
