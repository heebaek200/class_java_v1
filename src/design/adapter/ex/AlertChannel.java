package design.adapter.ex;

/**
 * 서버 알림 시스템이 요구하는 공통 인터페이스입니다.
 * 알림을 전달하는 구체적인 수단은 구현 클래스에서 결정합니다.
 */
public interface AlertChannel {

    /**
     * 서버 장애 알림을 전송합니다.
     * 모든 알림 채널은 이 메서드를 구현해야 합니다.
     * 호출하는 쪽은 구체적인 전송 방식을 알 필요가 없습니다.
     *
     * @param severity 장애의 심각도
     */
    void send(Severity severity);
}