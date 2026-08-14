package client_socket.ch01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientFile {

    private static final String SERVER_ADDR = "192.168.5.101";

    public static void main(String[] args) {

        try (Socket socket = new Socket(SERVER_ADDR, 5000)) {

            System.out.println("클라이언트 : 서버와 연결했습니다.");

            // 서버 측으로 메세지를 보내기 위한 출력 스트림 사용
            // socket + PrintWriter : autoFlush 처리
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("개발 현업에도 무사히 재접속하는 것이 목표입니다!\n" +
                    "예전 경험에만 기대지 않고 새로운 기술을 제대로 익혀 돌아가겠습니다.\nexit");

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
