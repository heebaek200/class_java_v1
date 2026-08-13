package client_socket.ch01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFile {

    private static final String SERVER_ADDR = "localhost";

    public static void main(String[] args) {

        try (Socket socket = new Socket(SERVER_ADDR, 5000)) {

            System.out.println("클라이언트 : 서버와 연결했습니다.");

            // 서버 측으로 메세지를 보내기 위한 출력 스트림 사용
            // socket + PrintWriter : autoFlush 처리
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("안녕하세요? 함께 파이팅해요!");

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
