package swing.ch03;

import javax.swing.*;
import java.awt.*;

public class MyImageFrame extends JFrame {

    // JPanel을 상속한 정적 내부 클래스 선언
    static class MyImagePanel extends JPanel {

        private Image image1;

        public MyImagePanel() {
            // 이미지 초기화
            image1 = new ImageIcon("rsc/images/image1.png").getImage();


        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            // 문자열 삽입
            g.drawString("이미지게임", 200,200);
            // 좌표값 (100, 100)에서 (300, 100)으로 이어지는 직선을 그어라
            g.drawLine(100, 100, 300, 100);

            // 이미지 삽입
            g.drawImage(image1, 100, 100, 100, 100, null);
        }

    } // end of inner class

    // JPanel을 상속한 클래스
    MyImagePanel myImagePanel;


    public MyImageFrame() {
        setTitle("중첩클래스 활용");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myImagePanel = new MyImagePanel();
        add(myImagePanel);

        setVisible(true);
    }

    // 테스트 코드 작성
    public static void main(String[] args) {
        new MyImageFrame();
    }
}
