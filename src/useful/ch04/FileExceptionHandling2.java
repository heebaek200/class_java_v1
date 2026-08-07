package useful.ch04;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class FileExceptionHandling2 {

    public static void main(String[] args) {

        FileInputStream fis = null;

        try {
            fis = new FileInputStream("test1.txt");
            byte[] data = fis.readAllBytes();                               // 파일 전체를 읽어 옴
            String content = new String(data, StandardCharsets.UTF_8);      // 읽은 값을 문자열로 변환

            System.out.println(content);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    System.out.println("파일을 닫는 도중 문제가 발생 됨");
                }
            }
        }

    } // end of class
}
