package socket.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

// 1:N 채팅 서버
public class ChatServer {

    private static final int PORT = 5002;

    // Vector는 멀티스레드 환경에서 안전한 동작을 한다.
    private static Vector<PrintWriter> clientWriterList = new Vector<>();

    // 내부 클래스 선언 및 스레드 상속
    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // 브로드캐스트(출력 스트림을 자료구조에 저장)
                clientWriterList.add(out);

                String message;
                while ( (message = in.readLine()) != null ) {
                    System.out.println("수신 : " + message);

                    // A, B, C 모두에게 받은 메세지를 현재 연결된 모든 클라이언트에게 전송 = 브로드캐스트
                    broadcast(message);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                // 클라이언트가 강제 종료 및 우리만의 프로토콜(exit)이 넘어오면 서버측에서 관리하고 있는
                // 자료구조에서 출력 스트림을 제거해야 한다.
                clientWriterList.remove(out);       // 출력 스트림 제거
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        private void broadcast(String msg) {
            for (PrintWriter w : clientWriterList) {
                // 자료구조에 저장된 출력스트림을 전체 꺼내서 하나씩 메세지 전송
                w.println(msg);
            }
        }

    } // end of inner class

    public static void main(String[] args) {
        System.out.println("---- 서버 시작 ----");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();

                // 클라이언트가 연결되면 새로운 객체를 생성하고 연결된 소켓 객체 주소값을 해당 클래스 필드에 할당한다.
                new ClientHandler(socket).start();

                System.out.println("클라이언트 접속, 현재 접속자 " + clientWriterList.size() + "명");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
