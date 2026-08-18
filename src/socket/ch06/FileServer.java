package socket.ch06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

    private static final int PORT = 5000;
    private static final String UPLOAD_DIR = "uploads";

    // 프로토콜을 정해보자
    // (1) 1 byte. 파일 이름의 길이 (N : 0~255)
    // (2) N byte. 파일 이름
    // (3) 나머지.(EOF까지) 파일 내용

    public static void main(String[] args) {

        // File 객체 사용
        File dir = new File(UPLOAD_DIR);

        if (!dir.exists()) {    // 폴더가 없다면 생성
            boolean created = dir.mkdirs();
            System.out.println("업로드 폴더 생성 : " + created);
        }

        System.out.println("파일 서버 시작 - 포트 : " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            Socket socket = serverSocket.accept();  // 연결될 때까지 블로킹

            System.out.println("클라이언트 연결됨 : " + socket.getInetAddress().getHostAddress());

            // 입출력용 스트림
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            //------------------------------------------------------
            // (1) 1 byte. 파일 이름의 길이 (N : 0~255)
            //------------------------------------------------------

            // byte가 아니라 int로 받는 이유: -1값 표현
            int nameLength = in.read();

            // 방어적 코드
            if (nameLength == -1) {
                System.out.println("클라이언트가 아무것도 보내지 않고 종료했습니다. EOF");
                return;
            }

            System.out.println("파일 이름 길이 : " + nameLength + " 바이트로 확인됨.");

            //------------------------------------------------------
            // (2) N byte. 파일 이름
            //------------------------------------------------------

            byte[] nameBuffer = new byte[nameLength];
            int nameRead = 0;   // 지금까지 읽어서 채운 바이트 수

            // 이 루프가 가장 중요함
            while (nameRead < nameLength) {
                int count = in.read(nameBuffer, nameRead, nameLength - nameRead);
                if (count == -1) {
                    throw new IOException("파일 이름을 입력받는 중에 연결이 끊겼습니다");
                }

                // 받은만큼 커서를 앞으로 민다. 루프 continue기능.
                nameRead += count;
            }

            String fileName = new String(nameBuffer);
            
            // 방어적 코드 : 악의적 클라이언트
            if (fileName.contains("..") || fileName.contains("/") || fileName.contains("\\")) {
                System.out.println("허용되지 않는 파일 이름입니다. : " + fileName);
                return;
            }
            System.out.println("수신할 파일 이름 : " + fileName);

            //------------------------------------------------------
            // (3) 나머지.(EOF까지) 파일 내용 -> 서버에 저장
            //------------------------------------------------------

            File target = new File(dir, fileName);
            FileOutputStream fos = new FileOutputStream(target, false);

            byte[] buffer = new byte[4 * 1024]; // 4KB
            int bytesRead;
            long total = 0;

            // 클라이언트가 shutdownOutput을 호출(클라이언트 소켓 종료 전에 -1을 보냄)할 때
            while ( (bytesRead = in.read(buffer)) != -1 ) {
                fos.write(buffer, 0, bytesRead);
                total += bytesRead;
            }
            System.out.println("저장 완료 : " + target.getPath() + " 총 " + total + " 바이트");

            //------------------------------------------------------
            // (4) 완료 응답 전송
            //------------------------------------------------------

            // 클라이언트 입장에서, 출력 방향만 닫았고 입력 방향은 열여 있는 프로토콜이므로 서버가 보낸 응답을 정상적으로 획득
            out.write(("업로드 성공 : " + fileName).getBytes());
            out.flush();






        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
