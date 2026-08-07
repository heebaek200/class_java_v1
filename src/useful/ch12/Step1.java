package useful.ch12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

public class Step1 {

    public static void main(String[] args) {
        // 지금 이 순간의 날짜 / 시간 가져오기
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();

        System.out.println(today);
        System.out.println(now);

        System.out.println("--------------------------------------------");
        // 원하는 날짜를 직접 설정 해보기
        LocalDate birthday = LocalDate.of(1988, 11, 18);
        System.out.println("설정한 날짜 : " + birthday);
        System.out.println(" - 요일 : " + birthday.getDayOfWeek());

        // 한글로 표현해보기
        System.out.println(birthday.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));




    }

}
