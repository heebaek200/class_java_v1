package io.ch07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;


public class BufferedKeyboard {

    public static void main(String[] args) {

        // 도전 과제:
        // 키보드에서 데이터를 보조 기반 스트림 활용해서 받아내고 화면(콘솔)에 출력하시오.

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(System.in);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(System.out);
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ( (bytesRead = bufferedInputStream.read(buffer)) != -1 ) {
                bufferedOutputStream.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
