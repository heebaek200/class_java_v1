package practice.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicLong;

public abstract class AbstractServer {

    /**
    프로토콜
     내용은 \n으로 구분된다.

     접속 직후
     클라이언트 → 서버: 이름
     서버 → 클라이언트: 서버가 발급한 ID

     채팅 중
     클라이언트 → 서버: 메시지만 전송
     서버 → 전체: ID, 이름, 메시지 전송
     */

    private ServerSocket serverSocket;

    // id 발급
    private static long idSequence = 0;
    private final Object lock = new Object();

    // Vector는 멀티스레드 환경에서 안전한 동작을 한다.
    //private static Vector<PrintWriter> clientWriterList = new Vector<>();
    private static Vector<ClientHandler> clientList = new Vector<>();

    // 내부 클래스 선언 및 스레드 상속
    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        private long clientId;
        private String clientName;

        public ClientHandler(long clientId, Socket socket) {
            this.clientId = clientId;
            this.socket = socket;
        }

        public PrintWriter getPrintWriter() {
            return out;
        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // 클라이언트 정보를 자료구조에 저장
                clientList.add(this);

                // 이름을 입력받고 id를 출력한다.
                clientName = in.readLine();
                out.println(clientId);


                System.out.println(in);

                System.out.println("받은 이름 : " + clientName);
                System.out.println("부여된 id : " + clientId);

                String message;
                while ( (message = in.readLine()) != null ) {
                    System.out.println("받은 메세지 : " + message);
                    // 받은 메세지를 현재 연결된 모든 클라이언트에게 전송 = 브로드캐스트
                    broadcast(clientId, clientName, message);
                }

                System.out.println(clientId + " - 입력대기 종료");

            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                // 클라이언트가 강제 종료 및 우리만의 프로토콜(exit)이 넘어오면 서버측에서 관리하고 있는
                // 자료구조에서 출력 스트림을 제거해야 한다.
                clientList.remove(this);       // 출력 스트림 제거
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        private void broadcast(long id, String name, String message) {
            synchronized (clientList) {
                for (ClientHandler c : clientList) {
                    PrintWriter w = c.getPrintWriter();
                    // 자료구조에 저장된 출력스트림을 전체 꺼내서 하나씩 메세지 전송
                    w.println(id);
                    w.println(name);
                    w.println(message);
                }
            }
        }

    } // end of inner class

    // final : 상속 불가
    public final void run() {
        try {
            connectToServerSocket();
            connectToClient();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    protected abstract void connectToServerSocket();

    private void connectToClient() throws IOException {

        while (true) {
            Socket socket = serverSocket.accept();

            // 클라이언트가 연결되면 새로운 객체를 생성하고 연결된 소켓 객체 주소값을 해당 클래스 필드에 할당한다.
            long clientId = 0;
            synchronized (lock) {
                clientId = idSequence + 1;
                idSequence++;
            }
            new ClientHandler(clientId, socket).start();

            System.out.println("클라이언트 접속, 현재 접속자 " + clientList.size() + "명");
        }
    }

}
