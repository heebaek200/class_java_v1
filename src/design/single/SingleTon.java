package design.single;

public class SingleTon {

    private static SingleTon instance;

    // 생성자를 private으로 선언, 외부에서 new 할 수 없음
    private SingleTon() {}

    public static synchronized SingleTon getInstance() {
        if (instance == null) {
            instance = new SingleTon();
        }

        return instance;
    }

}
