package design.adapter.ex;

/**
 * 서버 장애를 감지하고 알림을 전송합니다.
 * AlertChannel 인터페이스에만 의존하므로,
 * 구체적인 알림 수단을 알 필요가 없습니다.
 */
public class ServerMonitor {

    private final AlertChannel channel;

    public ServerMonitor(AlertChannel channel) {
        this.channel = channel;
    }

    /**
     * 서버 장애 발생 시 알림을 전송합니다.
     * 구체적인 전송 방식은 AlertChannel에 위임합니다.
     * 알림 수단이 변경되어도 이 메서드는 수정하지 않습니다.
     *
     * @param severity 장애의 심각도
     */
    public void report(Severity severity) {
        // 장애 발생 상황 출력
        System.out.println("[서버] 장애 감지: " + severity);

        // 공통 인터페이스를 통해 알림 전송
        channel.send(severity);
    }
}