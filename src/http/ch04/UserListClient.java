package http.ch04;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class UserListClient {

    public static void main(String[] args) {
        String urlString = "https://jsonplaceholder.typicode.com/users";
        HttpURLConnection conn = null;

        try {
            URL url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // 통신 시작
            int responseCode = conn.getResponseCode();
            System.out.println("응답 코드 확인 : " + responseCode);

            if (responseCode != 200) {
                System.out.println("요청 실패!");
                return;
            }

            // 응답 본문(HTTP 메세지 Body 영역에서 내용 추출)
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                // gson 라이브러리 활용
                Gson gson = new Gson();

                TypeToken<List<User>> typeToken = new TypeToken<>() {
                };

                List<User> userList = gson.fromJson(sb.toString(), typeToken.getType());

                System.out.println("유저 수 : " + userList.size());
                System.out.println("-----------------------------");
                for (User user : userList) {
                    System.out.println(user);
                }


                //User user = gson.fromJson(sb.toString(), User.class);
                //System.out.println(user);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }

    }

}
