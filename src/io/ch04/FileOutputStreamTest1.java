package io.ch04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest1 {

    public static void main(String[] args) {

        String data = "Hello, Java FileOutputStream...";

        //new FileOutputStream("assets/c.txt");     // 덮어쓰기
        //new FileOutputStream("assets/c.txt", true);     // 끝에 쓰기

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("assets/c.txt");



            fos.flush();
            // 단, fos.close() 메서드를 호출하면 자동으로 flush()하고 close된다.

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }


}
