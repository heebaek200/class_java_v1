package http.ch07;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HealthHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try (exchange) {

            SimpleHttpServer.sendResponse(exchange, 200, SimpleHttpServer.TYPE_TEXT, "OK");

        }
    }
}
