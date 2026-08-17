package practice.chat.gui;

import practice.chat.client.ChatClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClientFrame extends JFrame {

    // 프레임 타이틀
    public static final String FRAME_TITLE = "챗챗";
    // 프레임 폭
    public static final int FRAME_WIDTH = 500;
    // 프레임 높이
    public static final int FRAME_HEIGHT = 700;

    // 패널
    private JPanel mainPanel;
    private NorthPanel northPanel;
    private CenterPanel centerPanel;
    private SouthPanel southPanel;

    // 접속정보
    private ChatClient chatClient;

    public NorthPanel getNorthPanel() {
        return northPanel;
    }

    public CenterPanel getCenterPanel() {
        return centerPanel;
    }

    public SouthPanel getSouthPanel() {
        return southPanel;
    }

    public ChatClient getChatClient() {
        return chatClient;
    }

    public void setChatClient(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public ChatClientFrame() throws HeadlessException {
        initData();
        setInitLayout();
        setinitListener();
    }

    private void initData() {
        mainPanel = new JPanel();
        northPanel = new NorthPanel(this);
        centerPanel = new CenterPanel(this);
        southPanel = new SouthPanel(this);
    }

    private void setInitLayout() {
        setTitle(FRAME_TITLE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);   // 일단 아무것도 하지 말아봐 -> 리스너로 해결
        setLocationRelativeTo(null);

        // 메인 패널
        mainPanel.setLayout(new BorderLayout(0, 8));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );
        setContentPane(mainPanel);

        // 상단 패널
        mainPanel.add(northPanel, BorderLayout.NORTH);

        // 중앙 패널
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // 하단 패널
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        // 표시
        setVisible(true);
    }

    private void setinitListener() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeApplication();
            }
        });
    }

    // 종료
    private void closeApplication() {
        if (chatClient != null) {
            chatClient.close();
        }

        dispose();
    }

    // 실행
    public static void main(String[] args) {
        //new ChatClientFrame();

        // 이게 더 낫다는데 차후 확인
        SwingUtilities.invokeLater(ChatClientFrame::new);
    }
}
