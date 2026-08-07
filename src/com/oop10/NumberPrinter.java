package com.oop10;

/**
 * 번호표 출력기 클래스
 */
public class NumberPrinter {

    //private int waitNumber;
    // static: 인스턴스(각 객체)들이 공유할 수 있는 메모리 영역이다.
    static int waitNumber;         // 대기 번호

    // static 초기화
    static {
        waitNumber = 1;
    }

    private int id;

    public NumberPrinter(int id) {
        this.id = id;
    }

    /**
     * 번호표 출력 기능
     */
    public void printWaitNumber() {
        System.out.println(id + "번 기기의 대기 순번은: " + waitNumber);
        waitNumber++;
    }
}
