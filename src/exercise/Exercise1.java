package exercise;

public class Exercise1 {
    // 메인 함수
    public static void main(String[] args) {
        // 1. 데이터 10, 100, 200 을 변수 선언과 동시에 초기화를 하고 화면에 출력해 보세요.
        int data1 = 10;
        int data2 = 100;
        int data3 = 200;
        System.out.println("----- 예제1");
        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);

        // 2. int ageBox 상자에 20을 담아 보세요
        int ageBox;
        ageBox = 20;

        System.out.println("----- 예제2");
        System.out.println(ageBox);

        // 2.1 ageBox 상자의 값을 30으로 변경하고 기존에 담겨 있던 데이터를 다른 곳으로 옮겨 보세요
        int tempAgeBox;
        tempAgeBox = ageBox;
        ageBox = 30;

        System.out.println("----- 예제2.1");
        System.out.println(ageBox);
        System.out.println(tempAgeBox);

        // 3. int a = 1; int b = 3; 선언하고 a와 b에 담겨 있는 값을 서로 스위칭 해보세요
        int a = 1;
        int b = 3;
        int temp;

        temp = a;
        a = b;
        b = temp;


        System.out.println("----- 예제3");
        System.out.println(a);
        System.out.println(b);


    } // end of main
} // end of class
