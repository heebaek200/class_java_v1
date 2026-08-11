package useful.ch16;

public class Demo1 {

    public static void main(String[] args) {

        // 람다 표현식에 대해 알아보자.

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("작업자가 해야할 일 정의");
            }
        }).start();

        // 위 구현 클래스 코드를 람다식으로 바꿔 적어보자.
        new Thread(() -> System.out.println("여기도 작업자가 해야할 일 정의")).start();


        int x = 10;
        var y = 100;

    }

}
