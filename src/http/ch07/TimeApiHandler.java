package http.ch07;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeApiHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        try (exchange) {
            String method = exchange.getRequestMethod();

            System.out.println("메서드 : " + method);

            switch (method) {
                case "GET" -> handleGet(exchange);
                default -> {
                    exchange.getResponseHeaders().set("Allow", "GET");
                    SimpleHttpServer.sendResponse(exchange, 405,
                        SimpleHttpServer.TYPE_TEXT, "지원하지 않는 메서드입니다.");
                }
            }

        }

    }


    private void handleGet(HttpExchange exchange) throws IOException {
        try (exchange) {
            String result = new Gson().toJson(
                    new Time(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss")))
            );

            SimpleHttpServer.sendResponse(exchange, 200, SimpleHttpServer.TYPE_JSON, result);
        }
    }
}
