package io.ch04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TypingRecord {

    public static void main(String[] args) {
        // 키보드에서 값을 입력받아서 내가 정의한 파일에 그대로 저장시키는 기능

        System.out.println("======= 타자 연습 기록기 =======");

        // 도전 과제 1 - 입력 받은 문자열을 assets/typing.txt 파일에 바로 기록해주세요.
        // 도전 과제 2 - 파일에 한 단어를 입력할 때 소요시간을 함께 표시하시오.

        try (
                Scanner scanner = new Scanner(System.in);
                FileOutputStream fileOutputStream = new FileOutputStream("assets/typing.txt", true)
        ) {
            // 시작시간 체크
            LocalDateTime startDateTime = LocalDateTime.now();

            System.out.println("연습한 문장을 입력하세요 : ");
            fileOutputStream.write((startDateTime.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초 ms.SSS초"))
                    + " | 연습한 문장을 입력하세요 :\n")
                    .getBytes()
            );

            String input = scanner.nextLine();

            // 입력받은 문자열 파일에 출력
            fileOutputStream.write(input.getBytes());
            fileOutputStream.write(10); // \n
            fileOutputStream.flush();

            // 종료시간 체크
            LocalDateTime endDateTime = LocalDateTime.now();
            Duration interval = Duration.between(startDateTime, endDateTime);

            fileOutputStream.write(
                    (endDateTime.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss.SSS초"))
                    +
                    " | 경과시간 %d.%03d초".formatted(
                    interval.toSeconds(),
                    interval.toMillisPart())).getBytes()
            );
            fileOutputStream.write(10); // \n
            fileOutputStream.write(10); // \n

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
