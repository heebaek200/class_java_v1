package io.ch06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// 파일 복사 기능 (배운것까지만 활용해서)
public class FileCopy {

    //private static String fromFileName = "assets/test.zip";
    private static String fromFileName = "C:\\Users\\USER\\Documents\\lec\\dummy.zip";
    //private static String toFileName = "assets/test_copy.zip";
    private static String toFileName = "C:\\Users\\USER\\Documents\\lec\\dummy_copy2.zip";

    // 한 번에 읽을 바이트
    private static int lengthOneProc = 1024;

    public static void main(String[] args) {

        // 시작시각
        LocalDateTime start = LocalDateTime.now();
        System.out.println("시작 : " + start.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS")));

        copyFile();

        // 종료시각
        LocalDateTime end = LocalDateTime.now();
        System.out.println("종료 : " + end.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS")));

        // 경과시간
        Duration duration = Duration.between(start, end);
        System.out.printf("경과 : %d분 %d초 %dms (총 %dms)",
                duration.toMinutes(),
                duration.toSecondsPart(),
                duration.toMillisPart(),
                duration.toMillis()
        );

    }

    public static void copyFile() {
        try (
                FileInputStream fileInputStream = new FileInputStream(fromFileName);
                FileOutputStream fileOutputStream = new FileOutputStream(toFileName)
        ) {

            // 버퍼
            byte[] oneProc = new byte[lengthOneProc];
            int result;

            // 복사
            while ( (result = fileInputStream.read(oneProc)) > 0 ) {
                fileOutputStream.write(oneProc);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
