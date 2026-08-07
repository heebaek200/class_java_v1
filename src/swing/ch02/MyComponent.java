package swing.ch02;

import javax.swing.*;
import java.awt.*;

public class MyComponent extends JFrame {

    private JButton button;
    private JLabel label;
    private JTextField textField;
    private JPasswordField passwordField;
    private JCheckBox checkBox;

    public MyComponent() {
        setTitle("컴포넌트 확인");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initData() {
        button = new JButton("버튼1");
        label = new JLabel("글자나 이미지 아이콘 등을 사용");
        textField = new JTextField("아이디를 입력하세요", 10);
        passwordField = new JPasswordField("비밀번호를 입력하세요", 10);
        checkBox = new JCheckBox("동의");
    }

    private void setInitLayout() {
        setLayout(new FlowLayout(FlowLayout.LEADING, 20, 100));
        add(button);
        add(label);
        add(textField);
        add(passwordField);
        add(checkBox);

        setVisible(true);
    }

    // 실행 템플릿 메서드 설계
    public final void run() {
        initData();
        setInitLayout();
    }

    public JTextField getTextField() {
        return textField;
    }
}
