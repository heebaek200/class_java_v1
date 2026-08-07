package useful.ch09;

/**
 * 4. 익명 내부 클래스
 */
public class OuterClass4 {

    Runnable runnable;

    // 생성자
    public OuterClass4() {
        // 익명 내부 클래스를 사용하여 인터페이스나 추상클래스를 실제 객체처럼 생성할 수 있다.

        // runnable = new Runnable();   // 원래 인터페이스 객체 생성 안됨.
        new Runnable() {
            @Override
            public void run() {
                System.out.println("동작");
            }
        };
    }

    public static void main(String[] args) {
        new OuterClass4();      // 인스턴스의 이름이 없는 상태

    }

}
