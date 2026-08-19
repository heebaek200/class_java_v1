package http.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

// HTTP 통신으로 접근할 서버 주소
// https://jsonplaceholder.typicode.com             <-- 서버 주소
//                                     /todos/1     <-- 엔드 포인트
// https://jsonplaceholder.typicode.com/todos/1     <-- 요청 완성 주소
public class SimpleHttpClient {



    public static void main(String[] args) {

        String baseURL = "https://jsonplaceholder.typicode.com";
        String urlString = baseURL + "/todos/2";
        HttpURLConnection connection = null;

        try {
            // 1단계. URI로 파싱한 뒤 URL 객체로 변경
            URI uri = URI.create(urlString);
            URL url = uri.toURL();

            // 2단계. 연결 객체 생성
            connection = (HttpURLConnection) url.openConnection();

            // 3단계. 요청 방식 설정
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            // 4단계. 실제 TCP 연결 + 요청 전송
            int responseCode = connection.getResponseCode();
            System.out.println("응답 HTTP 상태 코드 + %d".formatted(responseCode));

            // 방어적 코드 작성
            if (responseCode != 200) {
                // 실패 응답의 본문은 getInputStream()이 아닌,
                // getErrorStream()으로 읽어야 함
                System.out.println("요청 실패");
                return;
            }

            // 5단계. 응답 본문 (HTTP 바디) 읽기 + 보조 스트림
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

                StringBuilder response = new StringBuilder();
                String line;
                while ( (line = reader.readLine()) != null ) {
                    response.append(line).append(System.lineSeparator());
                }

                System.out.println("응답 내용 : ");
                System.out.println(response);

            }


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 6단계. 연결 종료
            connection.disconnect();
        }

    }

}
