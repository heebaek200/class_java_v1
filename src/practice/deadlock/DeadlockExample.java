package practice.deadlock;

public class DeadlockExample {

    public static void main(String[] args) {
        BankAccount accountA = new BankAccount("A");
        BankAccount accountB = new BankAccount("B");

        Thread thread1 = new Thread("스레드 1") {
            @Override
            public void run() {
                accountA.transfer(accountB, 10_000);
            }
        };
        Thread thread2 = new Thread("스레드 2") {
            @Override
            public void run() {
                accountB.transfer(accountA, 20_000);
            }
        };

        thread1.start();
        thread2.start();
    }

}