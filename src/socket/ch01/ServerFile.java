package socket.ch01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {



    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            System.out.println("서버측 프로그램 시작 - 포트 번호 : 5000에서 대기 중 .......");

            Socket socket = serverSocket.accept();  // 클라이언트가 내 IP와 포트번호를 사용해 연결할 때까지 대기(블로킹)

            System.out.println("클라이언트가 연결되었습니다.");

            // I/O에서 배웠던 스트림 활용
            // 스트림 체이닝 연결 socket + 브릿지(InputStreamReader) + BufferedReader
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            // 클라이언트가 보낸 데이터 한 줄 읽어보자.
            String message = null;

            while ( (message = br.readLine()) != null ) {
                System.out.println("클라이언트가 보낸 메세지 : " + message);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
