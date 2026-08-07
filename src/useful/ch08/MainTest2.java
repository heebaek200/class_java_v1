package useful.ch08;

public class MainTest2 {

    public static void main(String[] args) {

        String str1 = "10A";
        String str2 = "20.5";
        String str3 = "true";

        int n1 = 0;
        try {
            n1 = Integer.parseInt(str1);
            System.out.println(n1);
        } catch (NumberFormatException e) {
            System.out.println("정수값이 아닙니다. : " + str1);
        }


        double d = Double.parseDouble(str2);
        System.out.println(d + 0.5);

        boolean b = Boolean.parseBoolean(str3);
        System.out.println(!b);

        System.out.println("----------------------");

        Integer int1 = 100;
        Integer int2 = 100;

        System.out.println(int1 == int2); // true


        Integer int3 = 200;
        Integer int4 = 200;

        System.out.println(int3 == int4); // false

    } // end of main

}
