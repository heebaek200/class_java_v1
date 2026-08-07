package swing.ch06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class MyFrame extends JFrame {

    // 프레임 폭
    private static final int FRAME_WIDTH = 1000;

    // 프레임 높이
    private static final int FRAME_HEIGHT = 600;

    // 현재 플레이어 X 정보
    private int currentPlayerX = 200;

    // 현재 플레이어 Y 좌표
    private int currentPlayerY = 510;

    // 적 좌우 행동
    private boolean playerLeft = true;

    // 현재 적 X 정보
    private int currentEnemyX = 300;

    // 현재 적 Y 좌표
    private int currentEnemyY = 510;

    // 적 좌우 행동
    private boolean enemyLeft = false;

    // 콤퍼넌트
    private JLabel backgroundMap;
    private JLabel player;
    private JLabel enemy;

    // shift 누르고 있는가?
    private boolean shiftPressed = false;

    // 플레이어 사망?
    private boolean playerDead = false;

    // 방향키 한 번에 이동하는 픽셀
    private int moveStep = 10;
    private int enemyMoveStep = 10;

    // 플레이어 이미지 L, R
    ImageIcon playerIconL = new ImageIcon("rsc/images/bubbles/playerL.png");
    ImageIcon playerIconR = new ImageIcon("rsc/images/bubbles/playerR.png");

    // 에너미 이미지 L, R
    ImageIcon enemyIconL = new ImageIcon("rsc/images/bubbles/enemyL.png");
    ImageIcon enemyIconR = new ImageIcon("rsc/images/bubbles/enemyR.png");

    // 벽 좌표 made by chat {x, y, width, height}
    private static final int[][] platformData = {
            { 62, 228,  68, 30},
            {218, 228, 572, 30},
            {879, 228,  58, 30},

            { 62, 347,  68, 30},
            {218, 347, 572, 30},
            {879, 347,  58, 30},

            { 62, 466,  68, 30},
            {218, 466, 572, 30},
            {879, 466,  58, 30}
    };
    private ArrayList<Rectangle> walls = new ArrayList<>();

    // 생성자
    public MyFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        setTitle("이미지 겹치기 연습");
        setSize(1000+40, 600+40);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // 배경 이미지 설정해보기
        ImageIcon backgroundICon = new ImageIcon("rsc/images/bubbles/backgroundMap.png");
        backgroundMap = new JLabel(backgroundICon);

        // 좌표기반 배치 : 컴포넌트 사이즈와 위치 지정
        // 배경 이미지와 동일한 창 사이즈 설정, 위치 (0, 0) 설정
        backgroundMap.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        backgroundMap.setLocation(0, 0);

        // 플레이어 이미지 초기화
        ImageIcon playIcon = playerIconL;
        player = new JLabel(playIcon);
        player.setSize(100, 100);
        player.setLocation(currentPlayerX, currentPlayerY);

        // 에너미 이미지 초기화
        ImageIcon enemyIcon = enemyIconR;
        enemy = new JLabel(enemyIcon);
        enemy.setSize(100, 100);
        enemy.setLocation(currentPlayerX, currentPlayerY);

        // 벽 리스트 관리
        for (int[] arr: platformData) {
            walls.add(new Rectangle(arr[0] - 30, arr[1] - 30, arr[2], arr[3]));     // 보정치 적용
        }
    }

    private void setInitLayout() {
        // 좌표기반 설정
        setLayout(null);
        add(backgroundMap);

        // 플레이어 설정
        backgroundMap.add(player);

        // 에너미 설정
        backgroundMap.add(enemy);
        setEnemyMovement();

        setVisible(true);
    }

    // 적 움직임 (스레드)
    private void setEnemyMovement() {

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    //enemyMoveStep
                    ImageIcon enemyIcon = null;

                    if (enemyLeft) {
                        // 좌측 이동
                        currentEnemyX -= enemyMoveStep;

                        if (currentEnemyX < 0 + 40) {      // 상하좌우 넘어서 이동 금지 (보정치 적용)
                            currentEnemyX = 0 + 40;
                            enemyLeft = false;
                            enemyIcon = enemyIconR;
                        } else {
                            enemyIcon = enemyIconL;
                        }
                    } else {
                        // 우측 이동
                        currentEnemyX += enemyMoveStep;

                        if (currentEnemyX > FRAME_WIDTH - 130) {
                            currentEnemyX = FRAME_WIDTH - 130;
                            enemyLeft = true;
                            enemyIcon = enemyIconL;
                        } else {
                            enemyIcon = enemyIconR;
                        }
                    }
                    // 위치 조정
                    enemy.setLocation(currentEnemyX, currentEnemyY);
                    // 아이콘 조정
                    enemy.setIcon(enemyIcon);

                    // 플레이어와 충돌시 사망
                    Rectangle playerBounds = new Rectangle(currentPlayerX, currentPlayerY, 40, 40);
                    Rectangle enemyBounds = new Rectangle(currentEnemyX, currentEnemyY, 40, 40);
                    if (playerBounds.intersects(enemyBounds)) {
                        // 충돌했습니다.
                        setPlayerDead();
                    }

                    // 시간차
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }.start();

    }

    // 플레이어의 죽음에 대한 처리
    private void setPlayerDead() {
        playerDead = true;

        ImageIcon deadIcon = null;
        ImageIcon backgroundMapServiceIcon = new ImageIcon("rsc/images/bubbles/backgroundMapService.png");

        if (playerLeft) {
            deadIcon = new ImageIcon("rsc/images/bubbles/playerLDie.png");
        } else {
            deadIcon = new ImageIcon("rsc/images/bubbles/playerRDie.png");
        }
        player.setIcon(deadIcon);

        backgroundMap.setIcon(backgroundMapServiceIcon);
    }

    private void addEventListener() {
        // 이벤트 리스너 등록 - 익명 내부 클래스로 처리
        addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if (playerDead) {
                    // 플레이어 사망 시 행동 불가 상태에 빠진다.

                    // 이 때 ESC를 누르면 초기화하고 싶어...
                    if (keyCode == KeyEvent.VK_ESCAPE) {
                        //initData();
                        //setInitLayout();
                        //addEventListener();
                    }
                    return;
                }


                switch (keyCode) {
                    case KeyEvent.VK_LEFT -> {
                        // 좌측 아이콘 세팅
                        playerLeft = true;
                        ImageIcon playIcon = playerIconL;
                        player.setIcon(playIcon);

                        currentPlayerX -= moveStep;
                        if (currentPlayerX < 0 + 40) {      // 상하좌우 넘어서 이동 금지 (보정치 적용)
                            currentPlayerX = 0 + 40;
                            e.consume();
                            return;
                        }

                        if (checkCollision()) {             // 각 벽 넘어서 이동 금지
                            currentPlayerX += moveStep;
                            e.consume();
                            return;
                        }
                    }
                    case KeyEvent.VK_RIGHT -> {
                        // 우측 아이콘 세팅
                        playerLeft = false;
                        ImageIcon playIcon = playerIconR;
                        player.setIcon(playIcon);

                        currentPlayerX += moveStep;
                        if (currentPlayerX > FRAME_WIDTH - 130) {
                            currentPlayerX = FRAME_WIDTH - 130;
                            e.consume();
                            return;
                        }

                        if (checkCollision()) {
                            currentPlayerX -= moveStep;
                            e.consume();
                            return;
                        }
                    }
                    case KeyEvent.VK_UP -> {
                        currentPlayerY -= moveStep;
                        if (currentPlayerY < 0 - 10) {
                            currentPlayerY = 0 - 10;
                            e.consume();
                            return;
                        }

                        if (checkCollision()) {
                            currentPlayerY += moveStep;
                            e.consume();
                            return;
                        }
                    }
                    case KeyEvent.VK_DOWN -> {
                        currentPlayerY += moveStep;
                        if (currentPlayerY > FRAME_HEIGHT - 90) {
                            currentPlayerY = FRAME_HEIGHT - 90;
                            e.consume();
                            return;
                        }

                        if (checkCollision()) {
                            currentPlayerY -= moveStep;
                            e.consume();
                            return;
                        }


                    }
                    default -> {
                        return;
                    }
                }

                // 위치 조정
                player.setLocation(currentPlayerX, currentPlayerY);
            }

            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });

        // 포커스 문제
        setFocusable(true);
        requestFocusInWindow();
    }

    // 벽과 캐릭터의 충돌 체크
    private boolean checkCollision() {
        //Rectangle playerBounds = player.getBounds();
        Rectangle playerBounds = new Rectangle(currentPlayerX, currentPlayerY, 40, 40);

        for (Rectangle wall : walls) {
            if (playerBounds.intersects(wall)) {
                // 충돌했습니다.
                return true;
            }
        }

        // 충돌하지 않았습니다.
        return false;
    }

    // 테스트 코드
    public static void main(String[] args) {
        new MyFrame();
    }
}
