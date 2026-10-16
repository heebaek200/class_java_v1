package design.builder;

// 햄버거 클래스 : 빌더 패턴을 적용한 클래스를 설계해보자
public class Burger {

    private String bread;
    private String patty;
    private String sauce;

    private Burger(Builder builder) {
        this.bread = builder.bread;
        this.patty = builder.patty;
        this.sauce = builder.sauce;
    }

    public static class Builder {
        private String bread;
        private String patty;
        private String sauce;

        public Builder bread(String bread) {
            this.bread = bread;
            return this;
        }
        public Builder patty(String patty) {
            this.patty = patty;
            return this;
        }
        public Builder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }
        public Burger build() {
            return new Burger(this);
        }
    } // end of inner class

    @Override
    public String toString() {
        return "Burger{" +
                "bread='" + bread + '\'' +
                ", patty='" + patty + '\'' +
                ", sauce='" + sauce + '\'' +
                '}';
    }
}
