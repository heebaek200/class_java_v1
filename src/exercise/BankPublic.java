package exercise;

import com.oop6.Bank;

public class BankPublic {

    public static void main(String[] args) {

        Bank bank1 = new Bank();

        // 어디서나 접근 가능한 public, 외부 패키지에 접근 못하게 하는 default
        //bank1.name = "우리은행";
        //System.out.println(bank1.name);

    }

}
