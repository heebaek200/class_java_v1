package ch03;

public class ConstantTest3 {

    // 코드 실행의 시작점
    public static void main(String[] args) {
        // 도전 과제 - 사각형의 면적을 구하는 코드를 작성하시오 (상수 활용)

        // 가로와 세로를 상수로 지정
        final int WIDTH = 10;
        final int HEIGHT = 5;
        int area = WIDTH * HEIGHT;

        System.out.printf("가로 %d, 세로 %d일 때, 사각형 면적: %d", WIDTH, HEIGHT, area);


    } // end of main

} // end of class
