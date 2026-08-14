package socket.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 클라이언트와 송수신 프로토콜이 달라서 정상 장동하지 않는 프로그램
 */
public class WhileServer {

    public static final int PORT_NUMBER = 5000;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT_NUMBER)) {
            System.out.println("--- 클라이언트의 연결을 기다립니다. ---");
            Socket socket = serverSocket.accept();  // 블로킹

            System.out.println("=== 클라이언트 연결 완료");

            // 입력 스트림 / 출력 스트림
            // 서버 측의 키보드에서 데이터를 입력받아 클라이언트로 전송

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));) {

                // 클라이언트가 먼저 메세지 -> 서버에서 데이터 읽고 그에 대한 응답
                String line;
                while ((line = reader.readLine()) != null) {
                    // 프로토콜 : exit 문자열이 들어오면 프로그램 종료(대소문자 구별없이)
                    if ("exit".equalsIgnoreCase(line)) {
                        break;
                    }

                    System.out.println("클라이언트 >> " + line);
                }

                // 키보드 입력
                System.out.println("-- 콘솔 로그 -- 내용 입력 ---");
                String serverKeyboardMessage = keyboardReader.readLine();

                // 클라이언트 출력 스트림을 통해 보내기
                writer.println(serverKeyboardMessage);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
