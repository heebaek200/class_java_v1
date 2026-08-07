package useful.ch10;

public class WorkerMain2 {

    // 메인 쓰레드
    public static void main(String[] args) {
        System.out.println("------------- 메인 Thread 시작 -------------");

        Worker2 worker2 = new Worker2();

        //Thread t = new Thread(worker2);
        //t.start();
        new Thread(worker2).start();


        System.out.println("------------- 메인 Thread 종료 -------------");
    } // end of main

}
