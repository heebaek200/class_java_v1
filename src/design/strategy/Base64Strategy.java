package design.strategy;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

// 전략1: Base64 인코딩
public class Base64Strategy implements EncodingStrategy {

    @Override
    public String encode(String text) {
        return Base64.getEncoder().encodeToString(
                text.getBytes(StandardCharsets.UTF_8)
        );
    }
}
