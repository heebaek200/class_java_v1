package practice.chat.client;

import practice.chat.gui.ChatClientFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class AbstractClient {

    private Socket socket;
    private PrintWriter socketWriterStream;
    private BufferedReader socketReaderStream;

    private ChatClientFrame chatClientFrame;

    public AbstractClient(ChatClientFrame chatClientFrame) {
        this.chatClientFrame = chatClientFrame;
    }

    // 메서드를 통해 socket 주입
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    // 접속
    public final void connect(String name) throws IOException, InterruptedException {
        try {
            connectToServer();
            setupStreams();
            startCommunication(name);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // abstract : 재정의 강제성 부여
    protected abstract void connectToServer() throws IOException;

    private void setupStreams() throws IOException {
        socketWriterStream = new PrintWriter(socket.getOutputStream(), true);
        socketReaderStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    private void startCommunication(String name) throws IOException {

        // 최초 한 번만 이름 전송
        socketWriterStream.println(name);

        // 서버가 발급한 ID 수신
        long myId = Long.parseLong(socketReaderStream.readLine());

        System.out.println("발급받은 ID: " + myId);

        new Thread(() -> {
            // 이후 서버가 보내는 채팅 메시지를 계속 대기
            while (true) {
                String senderIdLine = null;
                try {
                    senderIdLine = socketReaderStream.readLine();

                    if (senderIdLine == null) {
                        break;
                    }

                    long senderId = Long.parseLong(senderIdLine);

                    String senderName = socketReaderStream.readLine();

                    String message = socketReaderStream.readLine();

                    String fommatMessage = "[%s] %s".formatted(senderName, message);

                    // 채팅내용 출력
                    System.out.println(fommatMessage);
                    chatClientFrame.getCenterPanel().appendMessage(fommatMessage);
                } catch (IOException e) {
                    chatClientFrame.getNorthPanel().disconnect();
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public void sendChatMessage(String message) {
        // 서버로 메세지 송신
        Thread writeThread = new Thread(() -> {
            try {
                System.out.println("전송한다? : " + message);
                socketWriterStream.println(message);
            } catch (Exception e) {
                System.err.println("메세지 전송 중 오류 발생");
            }

        });

        writeThread.start();
    }

    // 종료
    public void close() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            System.err.println("소켓 종료 중 오류 발생");
        }
        socket = null;
    }

}
