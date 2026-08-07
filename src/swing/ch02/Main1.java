package swing.ch02;

public class Main1 {
    public static void main(String[] args) {
        MyComponent myComponent = new MyComponent();
        myComponent.run();

        // 문제1. 텍스트 필드에 접근하여 홍길동 입력
        myComponent.getTextField().setText("홍길동");
    }
}
