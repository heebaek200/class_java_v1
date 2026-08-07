package com.oop14;

public class Cal {

    public int sum(int n1, int n2) {
        return n1 + n2;
    }

    public int multiply(int n1, int n2) {
        return n1 * n2;
    }

} // end of class Cal


class ChildCal extends Cal {

    public int subtract(int n1, int n2) {
        return sum(n1, -n2);
    }

    // 부모클래스의 메서드를 재정의(Override)
    // 수정 요청! 곱하기 기능 - n1와 n2에 0이 들어오면 0을 입력하지 마시오 출력
    @Override
    public int multiply(int n1, int n2) {
        if (n1 == 0 || n2 == 0) {
            System.out.println("0을 하지마세요.");
        }

        return super.multiply(n1, n2);
    }


} // end of class ChildCal
