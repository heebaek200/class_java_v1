package swing.ch05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventListenerFrame extends JFrame {

    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;

    private JTextArea textArea;

    public KeyEventListenerFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        textArea = new JTextArea();
    }

    private void setInitLayout() {
        //add(textArea);

        textArea.setFont(new Font(Font.DIALOG, Font.PLAIN, 50));

        // 스크롤 추가
        // JScrollPane에 JTextArea를 넣어서 스크롤 기능 추가
        JScrollPane scrollPane = new JScrollPane(textArea);

        // 프레임이나 패널에 JScrollPane 추가
        add(scrollPane);

        setVisible(true);
    }

    private void addEventListener() {
        // 이벤트 리스너 등록 - 익명 내부 클래스로 처리
        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getSource() == textArea) {

                    System.out.println("키 누름 : " + e.getKeyCode());

                    // 도전과제: 이벤트를 받아서 위 쪽 화살표면
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_LEFT -> {
                            textArea.append("⬅️ 왼쪽\n");
                            e.consume();
                        }
                        case KeyEvent.VK_RIGHT -> {
                            textArea.append("➡️ 오른쪽\n");
                            e.consume();
                        }
                        case KeyEvent.VK_UP -> {
                            textArea.append("️⬆️ 위\n");
                            e.consume();
                        }
                        case KeyEvent.VK_DOWN -> {
                            textArea.append("⬇️ 아래\n");
                            e.consume();
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
            @Override
            public void keyTyped(KeyEvent e) {}
        });

    }

    public static void main(String[] args) {
        new KeyEventListenerFrame();
    }
}
