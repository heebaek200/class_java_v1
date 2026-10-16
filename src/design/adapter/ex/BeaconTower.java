package design.adapter.ex;

/**
 * 조선시대부터 사용하던 기존 봉화대입니다.
 * 외부에서 제공된 클래스로, 수정할 수 없다고 가정합니다.
 */
public class BeaconTower {

    /**
     * 지정된 개수만큼 봉화를 피웁니다.
     * 현대적인 장애 심각도 개념은 이해하지 못합니다.
     * 오직 봉화 개수만 입력받습니다.
     *
     * @param count 피울 봉화의 개수
     */
    public void lightFire(int count) {
        System.out.println("🔥 봉화 " + count + "개 점화!");
    }
}