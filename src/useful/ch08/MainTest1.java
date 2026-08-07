package useful.ch08;

public class MainTest1 {

    public static void main(String[] args) {

        // 1. Boxing, Unboxing
        int num = 3;
        Integer num2 = Integer.valueOf(3);
        int num3 = num2.intValue();

        // 2. Auto-Boxing, Unboxing
        Integer num4 = 17;
        int num5 = num4;

    } // end of main

}
