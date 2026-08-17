package practice.chat.client;

import practice.chat.gui.ChatClientFrame;

import java.io.IOException;
import java.net.Socket;

public class ChatClient extends AbstractClient {

    //private static final String SERVER_ADDR = "192.168.5.101";
    public static final String SERVER_ADDR = "127.0.0.1";
    public static final int PORT_NUMBER = 5003;

    public ChatClient(ChatClientFrame chatClientFrame) {
        super(chatClientFrame);
    }

    @Override
    protected void connectToServer() throws IOException {
        try {
            setSocket(new Socket(SERVER_ADDR, PORT_NUMBER));
        } catch (IOException e) {
            System.err.println("서버측 연결 도중 예외 발생 (IP, PORT 주소 확인)");
            throw e;
        }
    }

    //public static void main(String[] args) {
    //    new ChatClient("이름").run();
    //}
}
