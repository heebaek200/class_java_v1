package ch03;

/**
 * 형변환이란?
 * 데이터의 타입을 다른 타입으로 변경하는 것
 *  - 자동 형변환 / 강제 형변환
 */
public class TypeConversion2 {

    public static void main(String[] args) {

        // 자동형변환, 강제형변화 코드 작성해보기

        int totalScore = 155; // 두 과목의 합계 점수
        int count = 2;        // 과목 수

        // 잘못된 방법: 정수 / 정수
        double wrongAverage = totalScore / count;

        // 올바른 방법: 한쪽을 double로 강제 형변환
        double rightAverage = (double) totalScore / count;

        System.out.println("잘못된 평균: " + wrongAverage);
        System.out.println("올바른 평균: " + rightAverage);


    } // end of main

} // end of class
