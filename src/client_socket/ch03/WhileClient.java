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
public class WhileClient {

    private static final String SERVER_ADDR = "192.168.5.101";
    //private static final String SERVER_ADDR = "localhost";
    public static final int PORT_NUMBER = 5000;

    public static void main(String[] args) {

        // 1. 서버에 연결(소켓 준비)
        try (Socket socket = new Socket(SERVER_ADDR, PORT_NUMBER)) {

            // 2. 입력과 출력 스트림 준비
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));) {


                // 3. 서버측으로 보낼 메세지 준비 / 서버로 출력
                String line;
                String response;
                while (true) {
                    System.out.println("[client] 콘솔 로그 클라이언트 입력 >>>>");
                    String input = keyboardReader.readLine();

                    // 소켓과 연결된 출력스트림을 사용하여 서버에 데이터 보내기
                    writer.println(input);

                    // 프로토콜 : exit 문자열이 들어오면 프로그램 종료(대소문자 구별없이)
                    if ("exit".equalsIgnoreCase(input)) {
                        break;
                    }

                    // 4. 서버 응답 수신, 콘솔창에 출력
                    response = reader.readLine();
                    if ("exit".equalsIgnoreCase(response)) {
                        break;
                    }
                }


            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
