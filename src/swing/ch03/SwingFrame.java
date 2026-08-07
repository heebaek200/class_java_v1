package swing.ch03;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

// 중첩 클래스 활용
public class SwingFrame extends JFrame {

    JPanel panel = new JPanel() {

        private HashMap<String, Image> images = new HashMap();

        { // 초기화 블럭
            images.put("imposter", new ImageIcon("rsc/images/image1.png").getImage());
            images.put("red"     , new ImageIcon("rsc/images/flower_hachiue1_red.png").getImage());
            images.put("white"   , new ImageIcon("rsc/images/flower_hachiue2_white.png").getImage());
            images.put("pink"    , new ImageIcon("rsc/images/flower_hachiue3_pink.png").getImage());
            images.put("purple"  , new ImageIcon("rsc/images/flower_hachiue4_purple.png").getImage());
            images.put("blue"    , new ImageIcon("rsc/images/flower_hachiue5_blue.png").getImage());
            images.put("yellow"  , new ImageIcon("rsc/images/flower_hachiue6_yellow.png").getImage());
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 공간 색상
            g.setColor(new Color(255, 209, 220));
            //g.fillRect(200, 50, 100, 100);
            g.fillPolygon(new int[]{
                    100, 40, 480, 420
            }, new int[]{
                    60, 180, 180, 60
            }, 4);

            g.setColor(new Color(255, 250, 205));
            g.fillRect(100, 180, 320, 200);

            g.setColor(new Color(173, 216, 230));
            g.fillRect(300, 220, 80, 80);

            // 직선 생성
            g.setColor(Color.BLACK);
            g.drawLine(100, 60, 420, 60);
            g.drawLine(100, 60, 40, 180);
            g.drawLine(40, 180, 480, 180);
            g.drawLine(100, 180, 100, 380);
            g.drawLine(100, 380, 420, 380);
            g.drawLine(420, 380, 420, 380);
            g.drawLine(420, 180, 420, 380);
            g.drawLine(420, 180, 420, 380);
            g.drawLine(420, 60, 480, 180);

            g.drawLine(300, 220, 380, 220);
            g.drawLine(380, 300, 380, 220);
            g.drawLine(300, 220, 300, 300);
            g.drawLine(300, 300, 380, 300);
            g.drawLine(300, 260, 380, 260);
            g.drawLine(340, 220, 340, 300);

            // 현관문
            g.setColor(new Color(218, 197, 179));
            g.fillRect(150, 270, 70, 110);

            g.setColor(Color.BLACK);
            g.drawRect(150, 270, 70, 110);

            // 문 안쪽 장식
            g.drawRect(160, 280, 50, 40);
            g.drawRect(160, 330, 50, 40);

            // 문손잡이
            g.setColor(Color.YELLOW);
            g.fillOval(202, 325, 7, 7);
            g.setColor(Color.BLACK);
            g.drawOval(202, 325, 7, 7);

            // 현관 앞 돌길
            g.setColor(new Color(210, 200, 180));
            g.fillOval(155, 385, 65, 15);
            g.fillOval(145, 405, 85, 18);
            g.fillOval(135, 430, 105, 20);
            g.setColor(Color.BLACK);
            g.drawOval(155, 385, 65, 15);
            g.drawOval(145, 405, 85, 18);
            g.drawOval(135, 430, 105, 20);


            // 굴뚝
            g.setColor(new Color(198, 169, 144));
            g.fillRect(350, 85, 35, 55);
            g.setColor(Color.BLACK);
            g.drawRect(350, 85, 35, 55);

            // 연기
            g.setColor(Color.LIGHT_GRAY);
            g.fillOval(360, 60, 18, 18);
            g.fillOval(370, 42, 22, 22);

            // 이미지 삽입
            g.drawImage(images.get("red"), 60, 350, 31, 50, null);
            g.drawImage(images.get("white"), 90, 370, 31, 50, null);
            g.drawImage(images.get("pink"), 380, 370, 31, 50, null);
            g.drawImage(images.get("purple"), 410, 360, 31, 50, null);

        }

    };

    public SwingFrame(){
        setTitle("중첩클래스 활용");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SwingFrame();
    }
}
