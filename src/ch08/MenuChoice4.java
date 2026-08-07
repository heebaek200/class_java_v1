package ch08;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 */
public class MenuChoice4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 스캐너를 활용하여 문자열로 값 받기
        int menuNumber = scanner.nextInt(); // nextInt는 정수값만 입력하고 개행문자를 남긴다. 남겨진 \n을 소비하기
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.println("menuNumber: " + menuNumber);
        System.out.println("name: " + name);

    }
}
