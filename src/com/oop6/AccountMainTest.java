package com.oop6;

public class AccountMainTest {

    public static void main(String[] args) {
        Account account = new Account();

        // 입금
        account.deposit(10_000);
        account.withdraw(6_000);
        account.showInfo();

        // Access Modifier가 필요한 이유
        //  가상 시나리오...
        //  신입 개발자가 들어와서 실수로 입금하는 기능이 아닌 직접 변수에 접근해서 값을 수정한다면
        //  의도하지 않은 결과를 발생시킬 수 있다.
        //account.balance = 10_000;
        System.out.println("--------------------------------------");
        account.showInfo();

    }


}
