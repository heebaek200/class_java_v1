package useful.ch12;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Oldway {

    public static void main(String[] args) {

        // Date - JDK 1 버전에 만들어진 클래스

        // 1. 현재 시간 출력
        Date now = new Date();
        System.out.println("현재 시각 : " + now);
        // 문제점: 출력 형식 고정.

        // 2. Date로 특정 날짜 만들기
        Date date = new Date(2025, 4, 12);
        System.out.println("설정한 날짜 : " + date);
        // Date의 연도는 1900를 기준으로 하며, 월은 0부터 시작하기 때문에 3925년 5월 12일이 되어 버림.

        System.out.println("----------------------------------------------");

        // Calendar - JDK 1.1 버전에 만들어진 클래스
        Calendar cal = Calendar.getInstance();          // 싱글톤 패턴같은 인터페이스를 갖고 있다.
        cal.set(2025, 4, 12);   // 2025년 5월 12일
        System.out.println(cal.getTime());

        System.out.println("----------------------------------------------");

        // 3. LocalDate
        LocalDate localDate = LocalDate.of(2025, 5, 12); // 2025년 5월 12일
        System.out.println("설정한 날짜 : " + localDate);




    } // end of main

}
