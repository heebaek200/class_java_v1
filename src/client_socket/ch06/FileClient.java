package client_socket.ch06;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
  서버와 미리 약속한 데이터 순서 준수 ( 프로토콜 )
  (1) 1 byte. 파일 이름의 길이 (N : 0~255)
  (2) N byte. 파일 이름
  (3) 나머지.(EOF까지) 파일 내용
 */
public class FileClient {

     private static final String HOST = "localhost";
    //private static final String HOST = "192.168.5.5";
    private static final int PORT = 5000;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("전송할 파일 경로 예) C:\\work_java\\test.txt");
        //String filePath = sc.nextLine();
        String filePath = "C:\\heebaek\\work_space\\java_v1\\assets\\a.txt";

        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            System.out.println("파일이 존재하지 않거나 폴더 경로입니다. : " + filePath);
            return;
        }

        // 클라이언트 입장에서는 서버 측에 경로를 제외하고 파일명만 보내야 함.
        // C:\work_java\test.txt -> test.txt

        String fileName = file.getName();
        byte[] nameBytes = fileName.getBytes();

        // 방어적 코드, 프로토콜 - 이름의 길이를 1바이트에 담아 보내므로, 255를 넘으면 안됨. 한글은 UTF-8기준 (약 85글자).
        if (nameBytes.length > 255) {
            System.out.println("파일 이름이 너무 깁니다. (최대 255바이트)");
            return;
        }

        System.out.println("전송할 파일 : " + fileName + "( " + file.length() + " 바이트 )");

        try (Socket socket = new Socket(HOST, PORT)) {
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            //------------------------------------------------------
            // (1) 1 byte. 파일 이름의 길이 (N : 0~255)
            //------------------------------------------------------

            out.write(nameBytes.length);

            //------------------------------------------------------
            // (2) N byte. 파일 이름
            //------------------------------------------------------

            out.write(nameBytes);

            //------------------------------------------------------
            // (3) 나머지.(EOF까지) 파일 내용 -> 서버에 저장
            //------------------------------------------------------

            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[4 * 1024];
                int bytesRead;
                while ( (bytesRead = fis.read(buffer)) != -1 ) {
                    out.write(buffer, 0, bytesRead);
                }
            }
            out.flush();

            //------------------------------------------------------
            // (4) 전송 완료 신호
            //------------------------------------------------------

            // 소켓의 나가는 방향만 닫는다.
            socket.shutdownOutput();

            System.out.println("전송 완료");

            //------------------------------------------------------
            // (5) 완료 응답 수신
            //------------------------------------------------------

            byte[] responseBuffer = new byte[1024];
            int responseLength = in.read(responseBuffer);
            if (responseLength > 0) {
                System.out.println("서버 응답 : " + new String(responseBuffer, 0, responseLength));
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
