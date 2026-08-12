package io.ch02;

import java.io.IOException;

public class KeyboardInputTest2 {

    public static void main(String[] args) throws IOException {

        // in을 이용해 한 번에 여러 데이터를 받을 수 있는 기능을 만들어보자. (로우한 Scanner 구현)

        System.out.println("알파벳 여러개를 쓰고 enter를 누르시오");

        int i;

        while ( (i = System.in.read()) != '\n' ) {
            //System.out.println(" i : " + i);
            //System.out.println("문자로 변환 : " + (char) i);

            System.out.print((char) i);
        }

        
    }

}
