package practice.chat.gui;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;

public class CenterPanel extends JPanel {

    private ChatClientFrame parentFrame;
    private JTextArea chatArea;
    private JScrollPane scrollPane;

    public CenterPanel(ChatClientFrame parentFrame) throws HeadlessException {
        this.parentFrame = parentFrame;

        initData();
        setInitLayout();
        setinitListener();
    }

    private void initData() {
        chatArea = new JTextArea();

        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setMargin(new Insets(8, 8, 8, 8));

        scrollPane = new JScrollPane(chatArea);
    }

    private void setInitLayout() {
        setLayout(new BorderLayout());

        add(scrollPane, BorderLayout.CENTER);

        DefaultCaret caret =
                (DefaultCaret) chatArea.getCaret();

        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    private void setinitListener() {
    }

    // 받은 메세지 출력
    public void appendMessage(String message) {
        chatArea.append(message + System.lineSeparator());
    }

}
