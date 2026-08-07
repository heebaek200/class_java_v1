package ch05;

/**
 * 증감연산자
 */
public class Operation4 {
    public static void main(String[] args) {
        int value1 = 1;
        value1++;
        System.out.println(value1);

        int value2 = 1;
        value2--;
        System.out.println(value2);

        System.out.println("-------------");

        // 2.1 - 증감연산자가 항 앞에 올 경우 (전위 연산자) ++value
        // 2.1 - 증감연산자가 항 앞에 올 경우 (후위 연산자) value++

        int data1 = 10;
        int temp1 = ++data1;
        System.out.println("temp1: " + temp1);

        // 증감 후의 연산자 사용
        int data2 = 10;
        int temp2 = data2++;
        System.out.println("temp: " + temp2);

        // 문제1. 증감  연산자를 사용하고 결과 출력
        char alphabet = 'A';
        System.out.println(alphabet++);
        System.out.println(alphabet--);
        System.out.println(++alphabet);
        System.out.println(--alphabet);

    }
}
