package practice.chat.gui;

import practice.chat.client.AbstractClient;
import practice.chat.client.ChatClient;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class NorthPanel extends JPanel {

    private ChatClientFrame parentFrame;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField portField;
    private JButton connectButton;
    private JButton disconnectButton;
    private JLabel connectionLabel;
    private JPanel connectionPanel;

    public NorthPanel(ChatClientFrame parentFrame) throws HeadlessException {
        this.parentFrame = parentFrame;

        initData();
        setInitLayout();
        setinitListener();
    }

    private void initData() {
        connectionPanel = new JPanel();

        nameField = new JTextField("이름없음", 7); // 숫자는 화면에 표시할 글자 수
        addressField = new JTextField(ChatClient.SERVER_ADDR, 9);
        addressField.setEditable(false);
        portField = new JTextField(String.valueOf(ChatClient.PORT_NUMBER), 4);
        portField.setEditable(false);

        connectButton = new JButton("접속");
        disconnectButton = new JButton("종료");
        connectionLabel = new JLabel("● 연결 안 됨");
    }

    private void setInitLayout() {
        setLayout(new BorderLayout(0, 5));

        connectionPanel.setLayout(
                new FlowLayout(FlowLayout.LEFT, 5, 0)
        );

        connectionPanel.add(new JLabel("이름"));
        connectionPanel.add(nameField);

        connectionPanel.add(new JLabel("서버"));
        connectionPanel.add(addressField);

        connectionPanel.add(new JLabel("포트"));
        connectionPanel.add(portField);

        connectionPanel.add(connectButton);

        disconnectButton.setEnabled(false);
        connectionPanel.add(disconnectButton);

        add(connectionPanel, BorderLayout.CENTER);
        add(connectionLabel, BorderLayout.SOUTH);

    }

    private void setinitListener() {
        connectButton.addActionListener(e -> {

            String name = nameField.getText().trim();
            if ("".equals(name)) {
                name = "이름 없음";
            }
            nameField.setText(name);
            connectToServer();
        });

        disconnectButton.addActionListener(e -> {
            disconnect();
        });
    }

    public void disconnect() {
        parentFrame.getChatClient().close();
        statusDisconnected();
    }

    // 접속 시도 중
    public void statusConnecting() {
        connectButton.setEnabled(false);
        disconnectButton.setEnabled(false);
        nameField.setEditable(false);
        connectionLabel.setText("● 연결 시도 중");

        parentFrame.getCenterPanel().appendMessage("● 접속에 성공했습니다.");

        parentFrame.getSouthPanel().getSendButton().setEnabled(false);
        parentFrame.getSouthPanel().getMessageField().setEditable(false);
    }

    // 접속 실패
    public void statusDisconnected() {
        connectButton.setEnabled(true);
        disconnectButton.setEnabled(false);
        nameField.setEditable(true);
        connectionLabel.setText("● 연결 종료");

        parentFrame.getCenterPanel().appendMessage("● 접속이 중단 되었습니다.");

        parentFrame.getSouthPanel().getSendButton().setEnabled(false);
        parentFrame.getSouthPanel().getMessageField().setEditable(false);

        nameField.requestFocusInWindow();
    }

    // 접속 성공
    public void statusConnected() {
        System.out.println("연결 성공");

        connectButton.setEnabled(false);
        disconnectButton.setEnabled(true);
        nameField.setEditable(false);
        connectionLabel.setText("● 연결 성공");

        parentFrame.getSouthPanel().getSendButton().setEnabled(true);
        parentFrame.getSouthPanel().getMessageField().setEditable(true);

        parentFrame.getSouthPanel().getMessageField().requestFocusInWindow();
    }

    public void connectToServer() {
        String name = nameField.getText().trim();

        // 접속 시작
        statusConnecting();

        new Thread(() -> {
            try {
                ChatClient chatClient = new ChatClient(parentFrame);
                parentFrame.setChatClient(chatClient);
                chatClient.connect(name);

                statusConnected();
                // 이게 낫다는데 다음에 확인
//                SwingUtilities.invokeLater(() -> {
//                    statusConnected();
//                });

            } catch (IOException | InterruptedException e) {
                statusDisconnected();
//                SwingUtilities.invokeLater(() -> {
//                    statusDisconnected();
//                });
            }
        }).start();

    }

}
