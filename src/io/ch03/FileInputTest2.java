package io.ch03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputTest2 {

    public static void main(String[] args) {

        // 파일을 열면 받드시 받아주어야 하는데, 그 코드 자체가 반복적이라 불편함.

        try (FileInputStream in = new FileInputStream("assets/a.txt")) {

            int readData;
            while ( (readData = in.read()) != -1 ) {
                System.out.println((char) readData);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
