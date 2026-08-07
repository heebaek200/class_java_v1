package ch07;

public class WhileTest1 {

    public static void main(String[] args) {
        int i = 1;
        while (i <= 10) {
            System.out.println("i 값 : " + i);
            i++;
        }

        System.out.println("-------------");

        int num = 1;
        int sum = 0;
        while (num <= 10) {
            sum += num;
            num++;
        }
        System.out.println("sum 합계 : " + sum);

    }

}
