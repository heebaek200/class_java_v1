package practice.chat.gui;

import practice.chat.client.ChatClient;

import javax.swing.*;
import java.awt.*;

public class SouthPanel extends JPanel {

    private ChatClientFrame parentFrame;
    private JPanel inputPanel;
    private JTextField messageField;
    private JButton sendButton;

    public JButton getSendButton() {
        return sendButton;
    }

    public JTextField getMessageField() {
        return messageField;
    }

    public SouthPanel(ChatClientFrame parentFrame) throws HeadlessException {
        this.parentFrame = parentFrame;

        initData();
        setInitLayout();
        setinitListener();
    }

    private void initData() {
        messageField = new JTextField();
        sendButton = new JButton("전송");

        messageField.setEditable(false);
        sendButton.setEnabled(false);
    }

    private void setInitLayout() {
        setLayout(new BorderLayout(5, 0));

        add(messageField, BorderLayout.CENTER);
        add(sendButton, BorderLayout.EAST);
    }

    private void setinitListener() {
        sendButton.addActionListener(e -> sendMessage());
        messageField.addActionListener(e -> sendMessage());
    }

    public void sendMessage() {
        String message = messageField.getText().trim();

        System.out.println(message);

        if (message.isEmpty()) {
            return;
        }

        // 이후 서버 전송 기능 연결
        ChatClient chatClient = parentFrame.getChatClient();
        if (chatClient != null) {
            chatClient.sendChatMessage(message);
        }

        // 내용 비우고 포커스
        messageField.setText("");
        messageField.requestFocusInWindow();
    }

}
