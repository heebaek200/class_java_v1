package design.adapter.ex;

/**
 * 기존 봉화대를 현대적인 서버 알림 시스템에 연결합니다.
 * AlertChannel 인터페이스를 구현하고,
 * 내부적으로 BeaconTower의 기능을 호출합니다.
 */
public class BeaconAdapter implements AlertChannel {

    private final BeaconTower tower;

    public BeaconAdapter(BeaconTower tower) {
        this.tower = tower;
    }

    /**
     * 서버 장애의 심각도를 봉화 개수로 변환합니다.
     * INFO는 1개, WARNING은 3개, CRITICAL은 5개입니다.
     * 변환된 값을 기존 봉화대에 전달합니다.
     *
     * @param severity 장애의 심각도
     */
    @Override
    public void send(Severity severity) {
        // 현대적인 장애 수준을 봉화 개수로 변환
        int count = switch (severity) {
            case INFO -> 1;
            case WARNING -> 3;
            case CRITICAL -> 5;
        };

        // 기존 봉화대의 메서드 호출
        tower.lightFire(count);
    }
}