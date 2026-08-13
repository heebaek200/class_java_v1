package io.ch04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class SecretNote2 {

    private static final String FILE_PATH = "assets/secretnote.txt";

    public static class Cryption {

        // 암호화 (byte 단위)
        public static byte encrypt(byte c) {
            return (byte) (c + 3);
        }

        // 암호화 (String 단위)
        public static String encrypt(String str) {
            byte[] temp = str.getBytes();

            for (int i = 0 ; i < temp.length ; i++) {
                temp[i] = encrypt(temp[i]);
            }

            return new String(temp);
        }

        // 복호화 (byte 단위)
        public static byte decrypt(byte c) {
            return (byte) (c - 3);
        }

        // 복호화 (String 단위)
        public static String decrypt(String str) {
            byte[] temp = str.getBytes();

            for (int i = 0 ; i < temp.length ; i++) {
                temp[i] = decrypt(temp[i]);
            }

            return new String(temp);
        }

    }

    public static void saveRecord(Scanner scanner) {
        System.out.println("저장할 메모를 입력하세요 : ");
        String input = scanner.nextLine();

        // 비밀 메모장 기능을 구현해주세요.

        try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH, true)) {

            String cryptedString = Cryption.encrypt(input);
            fileOutputStream.write(
                    cryptedString.getBytes()
            );
            fileOutputStream.write(10); // \n

            System.out.println("입력이 완료되었습니다.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printRecord() {

        System.out.println("\n 저장된 메모 -------------------- ");

        try (FileInputStream fileInputStream = new FileInputStream(FILE_PATH)) {

            byte data;
            while ( (data = (byte) fileInputStream.read()) != -1 ) {
                System.out.print( (char) Cryption.decrypt(data) );
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("---- 비밀 메모장 ----");

        System.out.println("1. 문장 저장");
        System.out.println("2. 기록 보기");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            saveRecord(scanner);
        } else if (choice.equals("2")) {
            printRecord();
        }


        scanner.close();

    }

}
