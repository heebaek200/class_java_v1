package swing.exam;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GameBoyFrame extends JFrame {

    // 프레임 타이틀
    private String title = "게임보이 컨트롤러";
    // 프레임 폭
    private int frameWidth = 450;
    // 프레임 높이
    private int frameHeight = 320;

    // 각 버튼의 세팅
    private Map<String, Object>[] buttonSettings = new Map[8];

    // 공통 폰트
    Font uiFont = new Font(Font.DIALOG, Font.BOLD, 12);

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
        buttonSettings[0] = createButtonSetting("️︿", 70, 60, 45, 40);
        buttonSettings[1] = createButtonSetting("〈", 25, 100, 45, 40);
        buttonSettings[2] = createButtonSetting("〉", 115, 100, 45, 40);
        buttonSettings[3] = createButtonSetting("﹀", 70, 140, 45, 40);

        // 우측 A, B 버튼
        buttonSettings[4] = createButtonSetting("B", 260, 115, 65, 50);
        buttonSettings[5] = createButtonSetting("A", 340, 85, 65, 50);

        // 하단 SELECT, START 버튼
        buttonSettings[6] = createButtonSetting("SELECT", 130, 220, 95, 30);
        buttonSettings[7] = createButtonSetting("START", 235, 220, 95, 30);

    }

    // 데이터 세팅 헬퍼 메서드
    private Map<String, Object> createButtonSetting(String text, int x, int y, int width, int height) {
        Map spec = new HashMap<String, Object>();
        spec.put("text", text);
        spec.put("x", x);
        spec.put("y", y);
        spec.put("width", width);
        spec.put("height", height);

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

            // 패널에 버튼 추가
            mainPanel.add(button);
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
    public GameBoyFrame() {
        setTitle(title);
        setSize(frameWidth, frameHeight);
        setVisible(true);
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

        // 리스너 세팅
        initListener();
    }


    public static void main(String[] args) {
        new GameBoyFrame();
    }
}
