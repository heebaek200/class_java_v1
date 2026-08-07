package useful.ch12;

import java.time.LocalDate;
import java.time.Period;

public class Step3 {

    public static void main(String[] args) {
        LocalDate birth = LocalDate.of(1988, 11, 18);
        LocalDate today = LocalDate.of(2026, 8, 7);

        // Period - 날짜 차이
        Period age = Period.between(birth, today);

        System.out.println("나이 : 만 " + age.getYears() + "세");
        System.out.println("정확히 : " + age.getYears() + "년 " + age.getMonths() + "개월 " + age.getDays() + "일");

        // Period 객체를 그대로 출력하는 기능은 특유의 포맷
        System.out.println(age);

    }

}
