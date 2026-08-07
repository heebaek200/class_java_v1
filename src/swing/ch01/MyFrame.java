package swing.ch01;

import javax.swing.*;
import java.awt.*;


public class MyFrame extends JFrame {

    private JButton[] buttons;
    private int buttonLength;

    public MyFrame() {
        setTitle("배치 관리자 연습");
        setSize(600, 300);
        setVisible(true);

        // X 버튼을 누를 때 프로그램이 완전히 종료되도록 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonLength = 3;
        //initData();
        setInitLayout();
    }

    public void initData() {

        String[] emojis = {"🆗", "🆖", "💀"};

        buttons = new JButton[buttonLength];
        for (int i = 0 ; i < buttonLength ; i++) {
            buttons[i] = new JButton(emojis[i]);
            buttons[i].setFont(new Font("Segoe UI Emoji", Font.BOLD, 100));
            buttons[i].setMargin(new Insets(30, 0, 0, 0));
        }
    }

    public void setInitLayout() {
        // 배치관리자 선언
        FlowLayout flowLayout = new FlowLayout();

        setLayout(flowLayout);

        for (int i = 0 ; i < buttonLength ; i++) {
            add(buttons[i]);

            final int index = i;

            buttons[i].addActionListener(e -> {
                JOptionPane.showMessageDialog(this,(index+1) + " 버튼을 클릭했어요!");
                //System.out.println((index+1) + "번 버튼을 클릭했어요!");
            });
        }
    }


    // 테스트 코드
    public static void main(String[] args) {

        new MyFrame();  // 생성자 호출로 로직 동작

    } // end of main

}
