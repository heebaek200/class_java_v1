package useful.ch03;

public class StringTest1 {

    public static void main(String[] args) {

        String s1 = "aaa";
        String s2 = "aaa";
        String s3 = new String("aaa");
        String s4 = new String("aaa");


        System.out.println("s1 == s2 : " + (s1 == s2));
        System.out.println("s3 == s4 : " + (s3 == s4));
        System.out.println("s1 == s3 : " + (s1 == s3));

        System.out.println("----------------------------");

        System.out.println("s1.equals(s2) : " + s1.equals(s2));
        System.out.println("s3.equals(s4) : " + s3.equals(s4));
        System.out.println("s1.equals(s3) : " + s1.equals(s3));

        System.out.println("----------------------------");
        s1 += "a";
        System.out.println(s1);
        System.out.println("s1 == s2 : " + (s1 == s2));

    } // end of main

}
