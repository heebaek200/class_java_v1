package http.ch07;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// /api/users
// GET : 목록 조회
// POST : 새 사용자 등록
public class UserApiHandler implements HttpHandler {

    // DB 역할을 메모리로 대신함 (휘발성)
    private static final List<User> userList = new ArrayList<>();

    // id의 시퀀스
    private static int nextId = 1;

    static {   // static 초기화 블록
        addUser(new User("홍길동", "hong@naver.com"));
        addUser(new User("김철수", "kim@naver.com"));
    }

    private static synchronized int addUser(User user) {
        user.setId(nextId);
        nextId++;
        userList.add(user);

        return user.getId();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        try (exchange) {
            // /api/users 경로 + Method(GET:조회, POST:생성)

            String method = exchange.getRequestMethod();

            if (method.equals("GET")) {
                handleGet(exchange);
            } else if (method.equals("POST")) {
                handlePost(exchange);
            } else {
                // 405 METHOD NOT ALLOWED - 어떤 메서드가 가능한지 allow 헤더로 알려주는 규칙이 있다.
                exchange.getResponseHeaders().set("Allow", "GET, POST");
                SimpleHttpServer.sendResponse(exchange, 405,
                        SimpleHttpServer.TYPE_TEXT, "지원하지 않는 메서드입니다.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 목록을 복사해서 다시 돌려준다.
     *  복사하는 이유: Gson 로직 중 다른 스레드의 add 요청 시 예외가 발생할 수 있어서
     */
    private ArrayList<User> copyUserList() {
        return new ArrayList<>(userList);
    }

    /**
     * GET : 사용자 목록을 조회, 요청 HTTP body 없음
     * List<User>를 그대로 넘기면 Gson이 JSON 배열로 바꿔준다.
     */
    private void handleGet(HttpExchange exchange) throws IOException {
        SimpleHttpServer.sendJson(exchange, 200, copyUserList());
    }

    /**
     * POST : 사용자 생성, 요청 HTTP body 있음
     */
    private void handlePost(HttpExchange exchange) throws IOException {
        // 1. HTTP 요청 바디 읽기
        String requestBody = SimpleHttpServer.readRequestBody(exchange);
        System.out.println("POST 요청 [/api/users] 받은 본문 확인 : " + requestBody);

        // 2. JSON 문자열을 User 객체로 변환한다.
        // 주의
        User user;
        try {
            user = new Gson().fromJson(requestBody, User.class);
        } catch (JsonSyntaxException e) {
            SimpleHttpServer.sendResponse(exchange, 400,
                    SimpleHttpServer.TYPE_TEXT, "JSON 형식이 올바르지 않습니다.");

            return;
        }

        // 3. 검증
        if (user == null || user.getName() == null || user.getName().isBlank()) {
            SimpleHttpServer.sendResponse(exchange, 400,
                    SimpleHttpServer.TYPE_TEXT, "name은 반드시 있어야 합니다.");

            return;
        }

        if (user.getEmail() == null) {
            user.setEmail("");
        }

        // 4. id는 고정값이 아니므로 출력한다.
        int newId = addUser(user);

        // 5. 등록 성공 코드는 201 CREATED
        SimpleHttpServer.sendJson(exchange, 201, user);

    }

}
