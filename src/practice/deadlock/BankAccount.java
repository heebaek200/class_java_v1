package practice.deadlock;

public class BankAccount {

    private final String accountName;
    private int money = 100_000;

    public BankAccount(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountName() {
        return accountName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    // 입금 기능
    public synchronized void saveMoney(int money) {
        this.money += money;

        System.out.println(
                Thread.currentThread().getName()
                        + " : " + accountName + " 계좌에 "
                        + money + "원 입금"
        );
    }

    // 출금 기능
    public synchronized int withDraw(int money) {
        if (this.money >= money) {
            this.money -= money;

            System.out.println(
                    Thread.currentThread().getName()
                            + " : " + accountName + " 계좌에서 "
                            + money + "원 출금"
            );

            return money;
        }

        System.out.println(accountName + " 계좌 잔액 부족");
        return 0;
    }

    // 다른 계좌로 송금
    public synchronized void transfer(BankAccount targetAccount, int money) {
        System.out.println(
                Thread.currentThread().getName()
                        + " : " + accountName + " 계좌 잠금 획득"
        );

        if (this.money < money) {
            System.out.println(accountName + " 계좌 잔액 부족");
            return;
        }

        // 두 스레드가 각 계좌의 잠금을 획득하도록 시간을 줍니다.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        System.out.println(
                Thread.currentThread().getName()
                        + " : " + targetAccount.getAccountName()
                        + " 계좌 잠금 대기"
        );

        /*
         * targetAccount의 synchronized 메서드를 호출합니다.
         * 이때 현재 계좌의 잠금은 여전히 보유하고 있습니다.
         */
        targetAccount.saveMoney(money);

        this.money -= money;

        System.out.println(
                accountName + " → "
                        + targetAccount.getAccountName()
                        + " 송금 완료"
        );
    }

}
