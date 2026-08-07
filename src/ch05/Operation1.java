package ch05;

/**
 * 부호 연산자
 * 단항 연산자, 변수의 부호를 변경한다.
 * 단, 변수 안에 들어가 있는 값의 부호를 변경하려면 대입연산자와 함께 사용해야 한다.
 */
public class Operation1 {

    public static void main(String[] args) {
        int intData = 100;
        System.out.println(+intData);
        System.out.println(-intData);

        System.out.println("---------------");
        System.out.println("intData: " + intData);

        intData = -intData;

        System.out.println("---------------");
        System.out.println("intData: " + intData);
    }

}
