package design.strategy;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class UrlStrategy implements EncodingStrategy {

    @Override
    public String encode(String text) {
        return URLEncoder.encode(text, StandardCharsets.UTF_8);
    }
}
