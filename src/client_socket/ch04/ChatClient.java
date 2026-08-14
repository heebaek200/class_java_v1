package client_socket.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {

    private static final String SERVER_ADDR = "192.168.5.101";
    //private static final String SERVER_ADDR = "127.0.0.1";
    public static final int PORT_NUMBER = 5002;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("닉네임을 입력하세요 : ");
        String name = scanner.nextLine();

        try (Socket socket = new Socket(SERVER_ADDR, PORT_NUMBER)) {

            System.out.println(name + " 님, 채팅방 입장했음. (종료: exit)");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));) {

                Thread readThread = new Thread(() -> {
                    try {
                        String serverMessage;

                        while ((serverMessage = reader.readLine()) != null) {
                            // 프로토콜 - exit
                            if ("exit".equalsIgnoreCase(serverMessage)) {
                                System.out.println("서버가 종료를 원합니다.");
                                break;
                            }
                            System.out.println(serverMessage);
                        }

                    } catch (Exception e) {
                        System.err.println("서버가 강제 종료되었습니다.");
                    }
                });

                Thread writeThread = new Thread(() -> {
                    try {
                        String clientMessage;
                        while ((clientMessage = keyboardReader.readLine()) != null) {

                            writer.println(name + " : " + clientMessage);

                            if ("exit".equalsIgnoreCase(clientMessage)) {
                                System.out.println("클라이언트 종료 됨");
                                break;
                            }
                        }

                    } catch (Exception e) {
                        System.err.println(" 메세지 전송 중 오류 발생");
                    }
                });

                readThread.start();
                writeThread.start();
                readThread.join();
                writeThread.join();
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
