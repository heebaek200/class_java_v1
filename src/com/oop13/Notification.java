package com.oop13;

/**
 알림 전송 클래스 Notification 만들기

 우리는 메시지를 보낼 때 단순히 내용만 보낼 때도 있고, 받는 사람을 지정할 때도 있습니다. 메서드 오버로딩을 이용해 send라는 이름 하나로 다양한 알림을 보내는 코드를 완성해 보세요.

 ### 요구사항

 1. send(String message) : 메시지 내용만 출력합니다. (예: "일반 알림: [내용]")
 2. send(String message, int count) : 메시지를 입력받은 횟수만큼 반복해서 출력합니다.
 3. send(String receiver, String message) : 받는 사람과 내용을 출력합니다. (예: "[받는사람]님에게 메시지: [내용]")
 */
public class Notification {
    
    public static void send(String message) {
        System.out.println("일반 알림: [" + message + "]");
    }
    
    public static void send(String message, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("반복 알림" + (i+1) + ": [" + message + "]");
        }
    }
    
    public static void send(String receiver, String message) {
        System.out.println("[" + receiver + "]님에게 메시지: [" + message + "]");
    }

    // main
    public static void main(String[] args) {

        System.out.println("--------------------------------------------");

        send("일반 알림 테스트");

        System.out.println("--------------------------------------------");

        send("반복 알림 테스트", 5);

        System.out.println("--------------------------------------------");

        send("고양이", "전송 테스트");

        System.out.println("--------------------------------------------");

    }
    
}
