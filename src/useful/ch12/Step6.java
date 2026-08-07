package useful.ch12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Step6 {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDateTime currentTime = LocalDateTime.now();

        //1. 생일이 무슨 요일이었는지 (한글로)
        LocalDate myBirthday = LocalDate.of(1988, 11, 18);
        System.out.println("생일 요일: " + myBirthday.format(DateTimeFormatter.ofPattern("EEEE", Locale.KOREAN)));

        //2. 기준 날짜 시점의 만 나이
        System.out.println("만 나이: " + Period.between(myBirthday, now).getYears() + "세");

        //3. 태어난 지 총 며칠이 지났는지
        System.out.println("살아온 날: " + ChronoUnit.DAYS.between(myBirthday, now) + "일");

        //4. 기준 날짜부터 크리스마스까지 D-day
        LocalDate xmas = LocalDate.of(now.getYear(), 12, 25);
        // (크리스마스 지났다면 다음 해 크리스마스)
        if (xmas.isBefore(now)) {
            xmas = xmas.plusYears(1);
        }
        System.out.println("크리스마스까지: " + ChronoUnit.DAYS.between(now, xmas) + "일");

        //5. 기준 시각을 "2025년 05월 13일 오후 02시 30분" 형식으로 출력
        System.out.println("현재: " + currentTime.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 a hh시 mm분", Locale.KOREAN)));
    }

}
