package useful.ch11;

public class BankAccount {

    private int money = 100_000;


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    // 입금 기능
    public synchronized void saveMoney(int money) {
        int currentMoney = getMoney();

        // 입금에 3초가 걸린다고 가정
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        setMoney(currentMoney + money);
        System.out.println("입금 후 계좌 잔액 : " + getMoney());
    }

    // 출금 기능
    public synchronized int withDraw(int money) {
        int currentMoney = getMoney();
        int result = 0;

        // 출금에 1초가 걸린다고 가정
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 입금액 이상의 출금
        if (currentMoney >= money) {
            setMoney(currentMoney - money);
            result = money;

            System.out.println("출금 후 계좌 잔액 : " + getMoney());
        } else {
            System.out.println("잔액 부족");
        }

        return result;
    }



}
