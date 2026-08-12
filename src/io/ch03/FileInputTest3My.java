package io.ch03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class FileInputTest3My {

    public static void main(String[] args) {

        // 파일을 열면 받드시 받아주어야 하는데, 그 코드 자체가 반복적이라 불편함.

        try (FileInputStream in = new FileInputStream("assets/a.txt")) {

            int readData;
            byte[] param = new byte[255];

            while ( (readData = in.read(param)) != -1 ) {
                System.out.println((char) readData);
                System.out.println(Arrays.toString(param));
                System.out.println(new String(param, StandardCharsets.UTF_8));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
