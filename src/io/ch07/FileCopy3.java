package io.ch07;

import java.io.*;

// 파일 복사 기능 (배운것까지 활용해서)
public class FileCopy3 {


    public static void main(String[] args) {
        // 1. 파일 위치 지정 (원본, 복사될 경로)
        // 2. 스트림 (File I/O) - 바이트 기반
        // 3. 소요시간 측정


        String sourceFilePath = "assets/employees.zip";
        String destinationFilePath = "assets/employees_copy_2.zip";

        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             BufferedInputStream bis = new BufferedInputStream(fis);
             FileOutputStream fos = new FileOutputStream(destinationFilePath);
             BufferedOutputStream bos = new BufferedOutputStream(fos);

             ) {

//            int data;
//            while ( (data = fis.read()) != -1 ) {
//                fos.write(data);
//            }

            byte[] buffer = new byte[1024];
            int length;
            while ( (length = bis.read(buffer)) != -1 ) {
                bos.write(buffer, 0, length);
            }

            System.out.println("파일 복사 완료");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("나노 초 : " + duration);
        System.out.println("초 : " + duration / 1_000_000_000.0);
    }


}
