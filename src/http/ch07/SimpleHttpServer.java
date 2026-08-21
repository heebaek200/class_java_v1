package http.ch07;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

/**
 * 순수 Java로 만드는 HTTP 서버
 *
 * 등장 클래스:
 *      HttpServer : 포트 열고 연결 받는 것을 담당
 *      HttpHandler : 특정 경로의 처리 로직을 담당
 *      httpExchange : 요청 하나의 내용과 응답 처리를 담당
 *          요청이 들어올 때 마다 서버가 새로 만들어 handle()에 넘겨주고 끝나버린다.
 *
 *
 * 이 서버가 제공하는 경로
 *  GET     /           홈 화면
 *  GET     /health     서버 확인
 *  GET     /api/users
 *  POST    /api/users
 *
 */
public class SimpleHttpServer {

    private static final int PORT = 8080;
    private static final int THREAD_POOL_SIZE = 10; // 미리 생성해두는 스레드 개수

    static final String TYPE_HTML = "text/html; charset=UTF-8";
    static final String TYPE_TEXT = "text/plain; charset=UTF-8";
    static final String TYPE_JSON = "application/json; charset=UTF-8";

    public static void main(String[] args) throws IOException {

        // 1. http 서버 객체 생성
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);

        // 2. 경로와 담당 핸들러 연결
        // http://locahost:8080/
        server.createContext("/", new HomeHandler());

        // http://locahost:8080/health
        server.createContext("/health", new HealthHandler());

        // http://locahost:8080/api/users
        server.createContext("/api/users", new UserApiHandler());

        // 3. 요청을 처리할 스레드 풀 지정
        server.setExecutor(Executors.newFixedThreadPool(THREAD_POOL_SIZE));

        // 4. 서버시작
        server.start();
        System.out.println(">> HTTP 서버 시작 <<");

    }

    //////////////////////////////////////
    // 공통 메서드 정의
    //////////////////////////////////////

    // 응답을 내보낸다
    static void sendResponse(HttpExchange exchange, int statusCode, String contentType, String bodyText) throws IOException {

        // 1. 보낼 데이터 (매개변수 bodyText)

        // 2. 문자열을 바이트 배열로 바꾼다.
        byte[] bodyBytes = bodyText.getBytes(StandardCharsets.UTF_8);

        // 3. 응답의 종류를 헤더에 적는다.
        exchange.getResponseHeaders().set("Content-Type", contentType);

        // 4. 상태 코드와 본문 길이를 설정, 헤더를 출력한다.
        exchange.sendResponseHeaders(statusCode, bodyBytes.length);

        // 5. 바디를 출력한다.
        try (OutputStream out = exchange.getResponseBody()) {
            out.write(bodyBytes);
        }
    }

    // JSON으로 응답하는 경우
    static void sendJson(HttpExchange exchange, int statusCode, Object data) throws IOException {
        sendResponse(exchange, statusCode, TYPE_JSON, new Gson().toJson(data));
    }

    // 요청 본문을 문자열로 읽는 기능
    static String readRequestBody(HttpExchange exchange) throws IOException {
        StringBuffer requestBody = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8)
        )) {

            String line;
            while ( (line = reader.readLine()) != null ) {
                requestBody.append(line);
            }

        }

        return requestBody.toString();
    }

}
