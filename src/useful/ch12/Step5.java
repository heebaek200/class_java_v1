package useful.ch12;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Step5 {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.of(2026, 8, 7, 19, 17);
        System.out.println(now);

        // 포맷팅
        DateTimeFormatter korean = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        System.out.println(now.format(korean));

        DateTimeFormatter clockFormat = DateTimeFormatter.ofPattern("a hh시 mm분", Locale.KOREAN);
        System.out.println(now.format(clockFormat));

        DateTimeFormatter log = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        System.out.println(now.format(log));

    }

}
