package io.ch03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public class FileInputTest3 {

    public static void main(String[] args) {

        int[] byteSizes = {1, 10, 255, 1000};

        for (int j = 0 ; j < byteSizes.length ; j++) {

            // 시작 시각
            LocalDateTime startTime = LocalDateTime.now();


            // 프로세스
            byte[] buffer = new byte[byteSizes[j]];

            int readCount;

            try (FileInputStream in = new FileInputStream("assets/a.txt")) {

                while ((readCount = in.read(buffer)) != -1) {

                    for (int i = 0; i < readCount; i++) {
                        //System.out.print((char) buffer[i]);
                    }

                }


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // 끝 시각
            LocalDateTime endTime = LocalDateTime.now();

            // 시간차이 출력
            Duration duration = Duration.between(startTime, endTime);
            System.out.printf("%d. byte배열 사이즈가 %d일 때, 실행시간 : %dms %dns%n",
                    j+1,
                    byteSizes[j],
                    duration.toMillis(),
                    duration.toNanosPart());

        }

    }

}
