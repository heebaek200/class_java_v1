package socket.ch02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile2 {



    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000);
             FileWriter fileWriter = new FileWriter("assets/socketlog.txt", true);
         ) {

            System.out.println("서버측 프로그램 시작 - 포트 번호 : 5000에서 대기 중 .......");

            Socket socket = serverSocket.accept();  // 클라이언트가 내 IP와 포트번호를 사용해 연결할 때까지 대기(블로킹)

            // 문자 기반 읽기 스트림 (클라이언트 -> 서버)
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 문자 기반 쓰기 스트림 (서버 -> 클라이언트)
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            // 클라이언트가 보낸 데이터 한 줄 읽기
            String message = reader.readLine();
            System.out.println("클라이언트 메세지 : " + message);

            // 서버가 클라이언트로 응답 메세지 보내기
            writer.println("안녕, 나는 서버야.");

            // 메세지를 파일에 저장하기
            fileWriter.write(message);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
