package oop_test.ch05;

public class Main {

    public static void main(String[] args) {
        ItemService itemService = new ItemService();

        // 획득
        itemService.obtainItem("생명의구슬", "S");
        itemService.obtainItem("기합의띠", "A");
        itemService.obtainItem("축축한바위", "B");

        // 인벤토리 확인
        itemService.printInventory();

    }

}
