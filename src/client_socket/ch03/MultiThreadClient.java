package client_socket.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 서버와 송수신 프로토콜이 달라서 정상 장동하지 않는 프로그램
 */
public class MultiThreadClient {

    //private static final String SERVER_ADDR = "192.168.5.101";
    private static final String SERVER_ADDR = "127.0.0.1";
    public static final int PORT_NUMBER = 5001;

    public static void main(String[] args) {

        // 1. 서버에 연결(소켓 준비)
        try (Socket socket = new Socket(SERVER_ADDR, PORT_NUMBER)) {

            // 2. 입력과 출력 스트림 준비
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));) {

                // 3. 읽기 스레드 - 서버에게서 메세지 수신
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

                // 4. 쓰기 스레드 - 키보드에서 입력 받아 클라이언트로 송신
                Thread writeThread = new Thread(() -> {
                    try {
                        String clientMessage;
                        while ((clientMessage = keyboardReader.readLine()) != null) {

                            writer.println(clientMessage);

                            if ("exit".equalsIgnoreCase(clientMessage)) {
                                System.out.println("클라이언트 종료 됨");
                                break;
                            }
                        }

                    } catch (Exception e) {
                        System.err.println(" 메세지 전송 중 오류 발생");
                    }
                });

                // 5. 스레드 제어
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
