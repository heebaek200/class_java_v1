package client_socket.ch05;

import java.io.IOException;
import java.net.Socket;

public class ChatClient extends AbstractClient {

    //private static final String SERVER_ADDR = "192.168.5.101";
    private static final String SERVER_ADDR = "127.0.0.1";
    public static final int PORT_NUMBER = 5002;


    public ChatClient(String name) {
        super(name);
    }

    @Override
    protected void connectToServer() {
        try {
            setSocket(new Socket(SERVER_ADDR, PORT_NUMBER));
        } catch (IOException e) {
            System.err.println("서버측 연결 도중 예외 발생 (IP, PORT 주소 확인)");
        }
    }

    public static void main(String[] args) {
        new ChatClient("이희백").run();
    }
}
