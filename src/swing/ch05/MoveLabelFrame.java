package swing.ch05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MoveLabelFrame extends JFrame {

    // 방향키 한 번에 이동하는 픽셀
    private static final int MOVE_STEP = 10;

    // 프레임 폭
    private static final int FRAME_WIDTH = 500;

    // 프레임 높이
    private static final int FRAME_HEIGHT = 500;

    // 별표 폰트 크기
    private static final int FONT_SIZE = 30;

    // 현재 별표의 X 좌표
    private int currentX = 200;

    // 현재 별표의 Y 좌표
    private int currentY = 200;

    // 이동 횟수 표시
    private int moveCount = 0;

    // 콤퍼넌트
    private JLabel label;
    private JPanel panel;

    // 생성자
    public MoveLabelFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        setTitle("방향키로 별 움직이기");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // 별표 레이블 기본 설정
        label = new JLabel("☆");
        label.setFont(new Font("맑은 고딕", Font.BOLD, FONT_SIZE));
        label.setSize(50, 50);
        label.setLocation(currentX, currentY);

        // 배경 패널 기본 설정
        panel = new JPanel();
        mySetBackground();
    }

    private void setInitLayout() {
        // 레이아웃 기본 설정
        add(panel);
        panel.setLayout(null);
        panel.add(label);
        setVisible(true);
    }

    private void mySetBackground() {
        // 별표의 위치에 따라 패널 배경 색상 변경
        Color color = new Color(200, 180 + currentX/7, 180 + currentY/7);
        System.out.println(color);
        panel.setBackground(color);
    }

    private void mirage() {
        // 별표의 이동 위치에 따라 잔상 남기기 (Thread 사용)
        JLabel mylJLabel = new JLabel("☆");
        mylJLabel.setFont(new Font("맑은 고딕", Font.BOLD, FONT_SIZE));
        mylJLabel.setSize(50, 50);
        mylJLabel.setLocation(currentX, currentY);
        panel.add(mylJLabel);

        panel.revalidate();
        panel.repaint();


        new Thread() {
            @Override
            public void run() {
                int currentOpacity = 255;
                while (true) {
                    try {
                        currentOpacity -= 10;
                        if (currentOpacity < 0) {
                            // 완전히 흐려지면 컴퍼넌트 제거
                            remove(mylJLabel);
                            return;
                        }
                        mylJLabel.setForeground(new Color(255, 255, 255, currentOpacity));
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }.start();
    }

    private void addEventListener() {
        // 이벤트 리스너 등록 - 익명 내부 클래스로 처리
        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if (keyCode == KeyEvent.VK_ESCAPE) {
                    // ESC키로 초기화
                    currentX = 200;
                    currentY = 200;
                    moveCount = 0;

                    setTitle("방향키로 별 움직이기");
                    label.setLocation(currentX, currentY);

                    return;
                }

                // 방향키 공통 행동
                switch (keyCode) {
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_DOWN:
                        // 잔상효과
                        mirage();

                        // 누르는 동안 내부가 찬 별표로 변경
                        label.setText("★");

                        // 타이틀에 이동 횟수
                        setTitle("방향키로 별 움직이기 | 이동 횟수 : " + (++moveCount));

                    break;
                }

                switch (keyCode) {
                    case KeyEvent.VK_LEFT -> {
                        currentX -= MOVE_STEP;
                        if (currentX < 0) currentX = FRAME_WIDTH - FONT_SIZE - 10;      // 벽 너머 반대서 등장 (보정치 적용)
                        label.setLocation(currentX, currentY);
                    }
                    case KeyEvent.VK_RIGHT -> {
                        currentX += MOVE_STEP;
                        if (currentX > FRAME_WIDTH - FONT_SIZE - 10) currentX = 0;
                        label.setLocation(currentX, currentY);
                    }
                    case KeyEvent.VK_UP -> {
                        currentY -= MOVE_STEP;
                        if (currentY < 0) currentY = FRAME_HEIGHT - FONT_SIZE - 50;
                        label.setLocation(currentX, currentY);
                    }
                    case KeyEvent.VK_DOWN -> {
                        currentY += MOVE_STEP;
                        if (currentY > FRAME_HEIGHT - FONT_SIZE - 50) currentY = 0;
                        label.setLocation(currentX, currentY);
                    }
                }


                //System.out.println(currentX + " : " + currentY);

                // 이동에 따라 배경색상 변경
                mySetBackground();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // 키를 떼었을 때 빈 별표로 복구
                label.setText("☆");
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });

        // 포커스 문제 처리
        setFocusable(true);
        requestFocusInWindow();

    }

    public static void main(String[] args) {
        new MoveLabelFrame();
    }
}
