package swing.ch02;

import javax.swing.*;

public class NoLayout1 extends JFrame {

    private JButton button1;
    private JButton button2;
    private JButton button3;

    public NoLayout1() {
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initData();
        setInitLayout();
    }

    private void initData() {
        button1 = new JButton("button1");
        button2 = new JButton("button2");
        button3 = new JButton("button3");
    }

    private void setInitLayout() {
        setLayout(null);
        // null: 좌표 기반 배치
        // 주의점: 각 컴포넌트 크기, x, y 지정해야 함.
        // 0 -> x
        // ↓
        // y

        // button1
        button1.setSize(100, 100);
        button1.setLocation(200, 200);
        add(button1);

        // button2
        button2.setSize(100, 100);
        button2.setLocation(50, 50);
        add(button2);

        // button3
        button3.setSize(100, 100);
        button3.setLocation(350, 350);
        add(button3);

        // 마지막에 visible true
        setVisible(true);
    }

    public static void main(String[] args) {
        new NoLayout1();
    }

}
