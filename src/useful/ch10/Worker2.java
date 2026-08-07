package useful.ch10;

// 사용방법2. Runnable 인터페이스를 구현하기
public class Worker2 implements Runnable {

    // 약속된 실행의 메서드
    @Override
    public void run() {
        int i;
        for (i = 0 ; i < 200 ; i++) {
            System.out.print(i + "\t");
        }

    }
}
