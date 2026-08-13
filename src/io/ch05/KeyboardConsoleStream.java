package io.ch05;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class KeyboardConsoleStream {

    public static void main(String[] args) {

        // Scanner를 low level로 구현해보는 예제
        try (InputStreamReader reader = new InputStreamReader(System.in)) {

            // System.out.println() ->
            PrintWriter writer = new PrintWriter(System.out, true);

            System.out.println("텍스트를 입력하세요 ");

            int charCode;
            while ( (charCode = reader.read()) != -1 ) {        // ctrl + D
                writer.print((char) charCode);
            }
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
