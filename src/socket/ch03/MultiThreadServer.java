package socket.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {

    public static final int PORT_NUMBER = 5001;

    public static void main(String[] args) {
        System.out.println("--- 서버 실행 ---");

        try (ServerSocket serverSocket = new ServerSocket(PORT_NUMBER)) {
            System.out.println("--- 클라이언트의 연결을 기다립니다. ---");

            Socket socket = serverSocket.accept();  // 블로킹

            System.out.println("=== 클라이언트 연결 완료");

            // 입력 스트림 / 출력 스트림
            // 서버 측의 키보드에서 데이터를 입력받아 클라이언트로 전송

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));) {

                // 읽기 스레드 - 클라이언트에게 메세지 수신만
                Thread readThread = new Thread(() -> {
                    String clientMessage;
                    try {

                        while ( (clientMessage = reader.readLine()) != null ) {
                            System.out.println("/ping".equalsIgnoreCase(clientMessage.substring(0, 5)));
                            if ("/ping".equalsIgnoreCase(clientMessage.substring(0, 5))) {
                                long clientMs = Long.parseLong(clientMessage.substring(6));
                                long serverMs = System.currentTimeMillis();
                                long interval = serverMs - clientMs;

                                clientMessage = "클라이언트 시간: " + clientMs + " | 서버 시간: " + serverMs + " | 차이(ms) : " + interval;
                            }


                            System.out.println("[클라이언트 메세지] : " + clientMessage);
                            if ("exit".equalsIgnoreCase(clientMessage)) {
                                System.out.println("클라이언트가 종료를 원합니다.");
                                break;
                            }
                        }

                    } catch (IOException e) {
                        //throw new RuntimeException(e);
                        System.err.println("클라이언트가 강제로 연결을 끊었습니다.");
                    }
                });

                // 쓰기 스레드 : 키보드에서 값을 입력받아서 클라이언트에게 전달
                Thread writeThread = new Thread(new Runnable() {
                    // 복습 차원의 익명 클래스
                    @Override
                    public void run() {
                        String serverMessage;

                        try {

                            while (true) {
                                if ( (serverMessage = keyboardReader.readLine()) != null )  {
                                    if ("exit".equalsIgnoreCase(serverMessage)) {
                                        writer.println(serverMessage);
                                        System.out.println("서버가 종료했습니다.");
                                        break;
                                    }

                                    writer.println("[서버] 응답 메세지 " + serverMessage);
                                }
                            }

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }
                });

                // 각 스레드 실행
                readThread.start();
                writeThread.start();

                // 각 스레드 종료까지 대기
                readThread.join();
                writeThread.join();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
