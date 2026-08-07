package useful.ch10;

// 메인 쓰레드
public class WorkerMain {

    public static void main(String[] args) {
        System.out.println("------------- 메인 Thread 시작 -------------");
        System.out.println(Thread.currentThread());

        // 필요하다면 작업자 쓰레드를 만들어서 작업 수행
        Worker worker1 = new Worker("작업자1");

        // 약속2. start() 메서드로 로직 시작
        worker1.start();

        System.out.println("------------- 메인 Thread 종료 -------------");
    }

}
