package io.ch04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class SecretNote {

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


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("---- 비밀 메모장 ----");
        System.out.println("저장할 메모를 입력하세요 : ");
        String input = scanner.nextLine();

        // 비밀 메모장 기능을 구현해주세요.

        try (FileOutputStream fileOutputStream = new FileOutputStream("assets/secretnote.txt", true)) {

            String cryptedString = Cryption.encrypt(input);
            fileOutputStream.write(
                    cryptedString.getBytes()
            );
            fileOutputStream.write(10); // \n

            System.out.println("입력이 완료되었습니다.");

            //System.out.println("test : ");
            //String originString = Crypt.decrypt(cryptedString);
            //System.out.println(originString);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        scanner.close();

    }

}
