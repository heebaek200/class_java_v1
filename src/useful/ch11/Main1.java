package useful.ch11;

public class Main1 {

    public static void main(String[] args) {

        // 초기 10만원
        BankAccount bankAccount = new BankAccount();

        // bankAccount는 shared resource 상태
        Father father = new Father(bankAccount);
        Mother mother = new Mother(bankAccount);

        // 기대값 100_000 + 10_000 - 5_000 = 105_000
        father.start();
        mother.start();

    } // end of main

}
