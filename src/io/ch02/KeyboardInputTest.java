package io.ch02;

import java.io.IOException;

public class KeyboardInputTest {

    public static void main(String[] args) throws IOException {

        // 표준 출력 스트림
        System.out.print("\n\n문자를 입력하세요 : ");

        // 표준 입력 스트림
        int keyCode = System.in.read();

        System.out.println("반환된 정수값 : " + keyCode);
        System.out.println("문자로 변환 : " + (char) keyCode);

        System.err.println("[ERROR] 한글은 깨져서 표준 입출력만으로 처리가 힘들다");


    }

}
