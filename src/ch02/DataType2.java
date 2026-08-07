package ch02;

/**
 * 문자 데이터 타입
 */
public class DataType2 {
    public static void main(String[] args) {
        // Java의 char는 2바이트
        char charBox = '가';
        //char charBox2 = '가나';
        System.out.println(charBox);

        System.out.println('A');
        System.out.println('B');
        System.out.println('C');

        char alphabetA = 'A';
        //char alphabetB = "B";  // String

        System.out.println((int) alphabetA);
    } // end of main
} // end of class
