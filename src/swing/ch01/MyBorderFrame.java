package swing.ch01;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class MyBorderFrame extends JFrame {

    private LayoutManager layout;
    private JButton[] buttons;

    // 버튼 위치 정의
    private String[] buttonDirections = new String[]{
            BorderLayout.NORTH,
            BorderLayout.SOUTH,
            BorderLayout.CENTER,
            BorderLayout.WEST,
            BorderLayout.EAST
    };
    // 버튼 텍스트 정의
    private String[] buttonTexts = new String[]{
            "메뉴 ☰", "저장 \uD83D\uDCBE", "본문 \uD83D\uDCDD", "설정 ⚙\uFE0F", "목록 \uD83D\uDCC2"
    };

    public MyBorderFrame() {
        setTitle("BorderLayout 연습");
        setSize(600, 400);
        setVisible(true);
        // X 버튼을 누를 때 프로그램이 완전히 종료되도록 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 프레임 크기조절 금지
        setResizable(false);

        initData();
        setInitLayout();
        setInitListener();
    }

    // 데이터 설정
    private void initData() {
        // 배치관리자 선정
        layout = new BorderLayout();

        int length = 5;
        buttons = new JButton[length];

        for (int i = 0; i < length; i++) {
            buttons[i] = new JButton(buttonTexts[i]);
        }
    }

    // 레이아웃 설정
    private void setInitLayout() {
        setLayout(layout);

        for (int i = 0; i < buttons.length; i++) {
            add(buttons[i], buttonDirections[i]);
            //buttons[i].setFont(new Font("Malgun Gothic", Font.PLAIN, 30));

            // 버튼에 폰트 적용
            buttons[i].setFont(new Font(Font.DIALOG, Font.PLAIN, 30));

            // 버튼에 마진 적용
            buttons[i].setMargin(new Insets(10, 0, 0, 0));
        }

    }

    // 클릭 리스너 설정
    private void setInitListener() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(e -> {
                String buttonIcon = ((JButton) e.getSource()).getText();
                JOptionPane.showMessageDialog(this,buttonIcon + "을(를) 클릭했어요!");
                //System.out.println((index+1) + "번 버튼을 클릭했어요!");
            });
        }
    }

}
