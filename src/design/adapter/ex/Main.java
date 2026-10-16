package design.adapter.ex;

/**
 * 어댑터 디자인 패턴의 실행 예제입니다.
 * 서로 호환되지 않는 서버 알림 시스템과 봉화대를 연결합니다.
 */
public class Main {

    /**
     * 기존 봉화대를 어댑터로 감싸 서버 알림에 활용합니다.
     * 서버 모니터링 시스템은 봉화대의 존재를 알지 못합니다.
     * 서로 다른 인터페이스를 가진 객체들을 연결합니다.
     *
     * @param args 실행 인자
     */
    public static void main(String[] args) {
        // 기존 봉화대 생성
        BeaconTower tower = new BeaconTower();

        // 어댑터를 통해 알림 인터페이스로 변환
        AlertChannel channel = new BeaconAdapter(tower);

        // 서버 모니터링 시스템 생성
        ServerMonitor monitor = new ServerMonitor(channel);

        // 장애 상황별 알림 전송
        monitor.report(Severity.INFO);
        monitor.report(Severity.WARNING);
        monitor.report(Severity.CRITICAL);
    }
}