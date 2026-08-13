package io.ch07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedFileReader {

    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // 기반 스트림 - 대상은 파일
            fr = new FileReader("assets/typing.txt");

            // 보조 스트림  - 기반 스트림을 감싸야 한다
            br = new BufferedReader(fr);

            String line;

            while ( (line = br.readLine()) != null ) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 여는 순의 역순으로 닫는 개념을 이해하기 위해 finally 사용
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }

}
