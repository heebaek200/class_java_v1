package useful.ch12;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Step4 {

    public static void main(String[] args) {

        //LocalDateTime tempNow = LocalDateTime.now();
        //System.out.println(tempNow);

        LocalTime start = LocalTime.of(9, 0);
        LocalTime end = LocalTime.of(11, 30);

        // Duration - 시간 사이 간격
        Duration work = Duration.between(start, end);

        System.out.println(work);
        System.out.println("총 : " + work.toMinutes() + "분");
        System.out.println("총 : " + work.toHours() + "시간 " +  work.toMinutesPart() + "분");


    }

}
