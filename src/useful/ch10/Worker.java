package useful.ch10;

// 1. 스레드를 추가로 만들어서 사용하는 방법 - 상속 활용
public class Worker extends Thread {

    String name;

    public Worker(String name) {
        this.name = name;
    }

    // 약속되어 있는 부분: run() 추상 메서드 안에서
    @Override
    public void run() {
        //super.run();

        for (int i = 0; i < 10; i++) {
            System.out.println("worker : " + name + " : " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
