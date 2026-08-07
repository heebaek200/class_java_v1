package swing.exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class GameBoyFrame2 extends JFrame {

    // 프레임 타이틀
    private String title = "게임보이 컨트롤러";
    // 프레임 폭
    private int frameWidth = 450;
    // 프레임 높이
    private int frameHeight = 320;

    // 각 버튼의 세팅
    private Map<String, Object>[] buttonSettings = new Map[8];

    // 레이블 세팅
    private Map<String, Object>[] labelSettings = new Map[1];

    // 공통 폰트
    Font uiFont = new Font(Font.DIALOG, Font.BOLD, 12);
    Font labelFont = new Font(Font.DIALOG, Font.BOLD, 30);

    // 데이터 세팅
    private void initData() {

        /*
         +-------------------------------------------------------+
         |                 [전체 화면: 450 x 320]                |
         |                                                       |
         |       (70, 60)                                        |
         |         [⬆️]                                           |
         |  (25,100) (115,100)                  (340, 85)        |
         |    [⬅️]     [➡️]                            [A]         |
         |         [⬇️]                  (260, 115)               |
         |       (70,140)                    [B]                 |
         |                                                       |
         |                                                       |
         |              (130, 220)       (235, 220)              |
         |               [SELECT]          [START️]               |
         +-------------------------------------------------------+
         */

        // 좌측 위, 왼쪽, 오른쪽, 아래 버튼
        buttonSettings[0] = createComponentSetting("️︿", 70, 60, 45, 40, e -> moveEvent(1));
        buttonSettings[1] = createComponentSetting("〈", 25, 100, 45, 40, e -> moveEvent(2));
        buttonSettings[2] = createComponentSetting("〉", 115, 100, 45, 40, e -> moveEvent(3));
        buttonSettings[3] = createComponentSetting("﹀", 70, 140, 45, 40, e -> moveEvent(4));

        // 우측 A, B 버튼
        buttonSettings[4] = createComponentSetting("B", 260, 115, 65, 50, null);
        buttonSettings[5] = createComponentSetting("A", 340, 85, 65, 50, null);

        // 하단 SELECT, START 버튼
        buttonSettings[6] = createComponentSetting("SELECT", 130, 220, 95, 30, null);
        buttonSettings[7] = createComponentSetting("START", 235, 220, 95, 30, null);

        // 레이블 기본
        labelSettings[0] = createComponentSetting("😀", 200, 5, 50, 50, null);

    }

    // 동작 이벤트
    private void moveEvent(int direction) {
        System.out.println(direction);
    }

    // 데이터 세팅 헬퍼 메서드
    private Map<String, Object> createComponentSetting(String text, int x, int y, int width, int height, ActionListener e) {
        Map spec = new HashMap<String, Object>();
        spec.put("text", text);
        spec.put("x", x);
        spec.put("y", y);
        spec.put("width", width);
        spec.put("height", height);
        spec.put("actionEvent", e);

        return spec;
    }

    // 레이아웃 세팅
    private void initLayout() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);  // 레이아웃 매니저 미사용: 좌표 기준 레이아웃
        mainPanel.setBackground(new Color(220, 220, 220));  // 배경 연회색

        for (Map<String, Object> setting: buttonSettings) {
            // 버튼 생성
            JButton button = new JButton((String) setting.get("text"));
            setting.put("button", button);

            // 폰트 설정
            button.setFont(uiFont);

            // 좌표 설정
            button.setBounds(
                    (int) setting.get("x"),
                    (int) setting.get("y"),
                    (int) setting.get("width"),
                    (int) setting.get("height")
            );

            // 버튼 내부의 공백을 줄이고, 가운데 정렬
            button.setMargin(new Insets(0, 0, 0, 0));
            button.setHorizontalAlignment(SwingConstants.CENTER);
            button.setVerticalAlignment(SwingConstants.CENTER);

            // 리스너 세팅
            button.addActionListener((ActionListener) setting.get("actionEvent"));

            // 패널에 버튼 추가
            mainPanel.add(button);
        }

        for (Map<String, Object> setting: labelSettings) {
            // 레이블 생성
            JLabel label = new JLabel((String) setting.get("text"));
            setting.put("label", label);

            // 폰트 설정
            label.setFont(labelFont);

            // 좌표 설정
            label.setBounds(
                    (int) setting.get("x"),
                    (int) setting.get("y"),
                    (int) setting.get("width"),
                    (int) setting.get("height")
            );

            // 레이블 내부의 공백을 줄이고, 가운데 정렬
            //label.setMargin(new Insets(0, 0, 0, 0));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.CENTER);

            // 패널에 레이블 추가
            mainPanel.add(label);
        }

        add(mainPanel);
    }

    // 리스너 세팅
    private void initListener() {
        for (Map<String, Object> setting: buttonSettings) {
            JButton button = (JButton) setting.get("button");

            button.addActionListener(e -> {
                JButton buttonConponent = (JButton) e.getSource();
                System.out.println(buttonConponent.getText() + " 버튼을 눌렀습니다.");
            });
        }
    }

    // 생성자
    public GameBoyFrame2() {
        setTitle(title);
        setSize(frameWidth, frameHeight);
        // X 버튼을 누를 때 프로그램이 완전히 종료되도록 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 프레임 크기조절 금지
        setResizable(false);
        // 화면 중앙에 프레임 띄우기
        setLocationRelativeTo(null);

        // 데이터 세팅
        initData();

        // 레이아웃 세팅
        initLayout();

        setVisible(true);
    }


    public static void main(String[] args) {
        new GameBoyFrame2();
    }
}
