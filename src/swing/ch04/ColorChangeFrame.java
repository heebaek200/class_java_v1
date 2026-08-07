package swing.ch04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ColorChangeFrame extends JFrame implements ActionListener {
    // 10가지 파스텔 색상 객체를 저장하는 리스트
    private static final List<Color> PASTEL_COLORS = new ArrayList<>();
    private static final List<Color> HOT_COLORS = new ArrayList<>();
    private static final Random RANDOM = new Random();

    private JButton button1;
    private JButton button2;
    private JPanel panel1;

    {
        // 부드러운 파스텔 톤 RGB 값으로 Color 객체 초기화
        PASTEL_COLORS.add(new Color(255, 179, 186)); // 파스텔 핑크
        PASTEL_COLORS.add(new Color(255, 223, 186)); // 파스텔 피치
        PASTEL_COLORS.add(new Color(255, 255, 186)); // 파스텔 옐로우
        PASTEL_COLORS.add(new Color(186, 255, 201)); // 파스텔 그린
        PASTEL_COLORS.add(new Color(186, 225, 255)); // 파스텔 블루
        PASTEL_COLORS.add(new Color(221, 186, 255)); // 파스텔 퍼플
        PASTEL_COLORS.add(new Color(255, 204, 229)); // 파스텔 로즈
        PASTEL_COLORS.add(new Color(204, 255, 255)); // 파스텔 민트
        PASTEL_COLORS.add(new Color(240, 224, 201)); // 파스텔 베이지
        PASTEL_COLORS.add(new Color(218, 232, 212)); // 파스텔 세이지

        // 쨍한 색상
        HOT_COLORS.add(new Color(0, 102, 255)); // 일렉트릭 블루
        HOT_COLORS.add(new Color(51, 255, 0)); // 네온 그린
        HOT_COLORS.add(new Color(255, 0, 127)); // 핫핑크
        HOT_COLORS.add(new Color(255, 102, 0)); // 비비드 오렌지
        HOT_COLORS.add(new Color(255, 230, 0)); // 레몬 옐로우
        HOT_COLORS.add(new Color(153, 0, 255)); // 일렉트릭 퍼플
        HOT_COLORS.add(new Color(0, 221, 255)); // 시안 블루
        HOT_COLORS.add(new Color(128, 255, 0)); // 라임 그린
        HOT_COLORS.add(new Color(255, 0, 51)); // 체리 레드
        HOT_COLORS.add(new Color(191, 255, 0)); // 비비드 옐로우 그린
    }

    public ColorChangeFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        button1 = new JButton("랜덤컬러");
        button2 = new JButton("정지");
        panel1 = new JPanel();
    }

    private void setInitLayout() {
        setLayout(new BorderLayout());

        panel1.setBackground(Color.BLACK);
        panel1.add(button1);
        panel1.add(button2);

        add(panel1);

        setVisible(true);
    }

    private void addEventListener() {
        //
        button1.addActionListener(this);
        button2.addActionListener(this);
    }

    private int selectedColorIndex;
    private boolean flg;

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton selected = (JButton) e.getSource();

        if (selected == button1) {

            new Thread() {
                @Override
                public void run() {
                    flg = true;
                    while (true) {
                        try {

                            int index = RANDOM.nextInt(PASTEL_COLORS.size());
                            if (selectedColorIndex == index) index = (index + 1) % PASTEL_COLORS.size();
                            selectedColorIndex = index;
                            panel1.setBackground(PASTEL_COLORS.get(index));

                            Thread.sleep(250);

                            if (!flg) break;
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }.start();

        } else if (selected == button2) {
//            int index = RANDOM.nextInt(PASTEL_COLORS.size());
//            if (selectedColorIndex == index) index++;
//            selectedColorIndex = index;
//            panel1.setBackground(HOT_COLORS.get(index));

            flg = false;
        }
    }

    public static void main(String[] args) {
        new ColorChangeFrame();
    }

}
