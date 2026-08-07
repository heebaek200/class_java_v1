package useful.ch12;

import java.time.Duration;
import java.time.LocalDateTime;

public class Step7 {

    static int sum = 0;

    // 1부터 1억까지 더하는 로직이 실제로 몇 밀리초 걸리는지 측정하는 프로그램입니다.
    public static void main(String[] args) {

        LocalDateTime startDateTime = LocalDateTime.now();

        for (int i = 1; i <= 100_000_000; i++) {
            sum += i;
        }

        LocalDateTime endDateTime = LocalDateTime.now();

        Duration duration = Duration.between(startDateTime, endDateTime);
        System.out.println("경과시간: " + duration.toMillis() + "ms");
        System.out.println("(" + duration.toSeconds() + "초 " + duration.toMillisPart() + "ms)");

    }
}
