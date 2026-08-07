package useful.ch04;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class FileExceptionHandling3 {

    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream("test1.txt")) {

            byte[] data = fis.readAllBytes();                               // 파일 전체를 읽어 옴
            String content = new String(data, StandardCharsets.UTF_8);      // 읽은 값을 문자열로 변환

            System.out.println(content);

        }  catch (Exception e) {
            e.printStackTrace();
        }

    } // end of class
}
