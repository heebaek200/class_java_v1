package practice.chat.server;

import java.io.IOException;
import java.net.ServerSocket;

public class ChatServer extends AbstractServer {

    private static final int PORT = 5003;

    @Override
    protected void connectToServerSocket() {
        try {
            setServerSocket(new ServerSocket(PORT));
        } catch (IOException e) {
            System.err.println("서버측 연결 도중 예외 발생 (IP, PORT 주소 확인)");
        }
    }

    public static void main(String[] args) {
        new ChatServer().run();
    }
}
