package useful.ch11;

public class Mother extends Thread {

    BankAccount bankAccount;

    public Mother(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        // 어머니가오천원출금하신다
        bankAccount.withDraw(5_000);
    }
}
