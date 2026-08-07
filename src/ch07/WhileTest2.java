package ch07;

public class WhileTest2 {

    public static void main(String[] args) {

        boolean flag = true;
        int start = 0;
        final int END = 50;

        while (flag) {
            System.out.println("start : " + start);
            if (start == END) {
                System.out.println("프로그램을 종료합니다.");
                flag = false;
            }
            start++;
        }


    }

}
