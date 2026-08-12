package practice;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Scanner;

public class SecretNoteHistory {

    private static final String FILE_PATH = "assets/secretnote2.txt";

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");

    public static class Cryption {

        // 암호화
        public static String encrypt(String str) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);

            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] + 3);
            }

            return Base64.getEncoder().encodeToString(bytes);
        }

        // 복호화
        public static String decrypt(String str) {
            byte[] bytes = Base64.getDecoder().decode(str);

            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] - 3);
            }

            return new String(bytes, StandardCharsets.UTF_8);
        }
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("======= 비밀 메모 기록기 =======");
            System.out.print("저장할 메모를 입력하세요 : ");

            // 입력 전 시각
            LocalDateTime startTime = LocalDateTime.now();

            String input = scanner.nextLine();

            // 입력 후 시각
            Duration duration =
                    Duration.between(startTime, LocalDateTime.now());

            // 파일에 입력
            saveNote(input, startTime, duration);

            // 파일로부터 출력
            printNotes();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 암호화된 메세지와 시간을 파일에 입력
    private static void saveNote(String input, LocalDateTime createdAt, Duration duration) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(FILE_PATH, true), StandardCharsets.UTF_8))) {

            String record = "%s|%d|%s".formatted(
                    createdAt.format(FORMATTER),
                    duration.toMillis(),
                    Cryption.encrypt(input)
            );

            writer.write(record);
            writer.newLine();

        }
    }

    // 파일의 내용을 출력
    private static void printNotes() throws IOException {

        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return;
        }

        System.out.println("\n======= 저장된 메모 =======");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(file), StandardCharsets.UTF_8))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] record = line.split("\\|", 3);

                String createdAt = record[0];
                double seconds =
                        Long.parseLong(record[1]) / 1000.0;
                String note = Cryption.decrypt(record[2]);

                System.out.printf(
                        "%s | 입력 시간 %.3f초 | %s%n",
                        createdAt,
                        seconds,
                        note
                );
            }

        }
    }
}