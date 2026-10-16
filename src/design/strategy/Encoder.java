package design.strategy;

// 전략을 가지고 있다가 실제로 사용하는 객체
// 어떤 방식으로 인코딩하는지는 모르겠고, 맥락만 알고 있음.
public class Encoder {

    private EncodingStrategy strategy;

    // 생성할 때 전략을 갖도록 함
    public Encoder(EncodingStrategy strategy) {
        this.strategy = strategy;
    }

    // 전략을 교체할 수 있도록 setter도 만들어 줌
    public void setStrategy(EncodingStrategy strategy) {
        this.strategy = strategy;
    }

    // 핵심 행동
    // 인코딩 작업을 현재 전략에게 위임한다. (((조건문이 사라짐)))
    public String encode(String text) {
        return strategy.encode(text);
    }
}
