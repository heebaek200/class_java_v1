package oop_test.tickets;

public class WeekendPricePolicy implements PricePolicy {

    private int extraPercent = 12;

    /**
     * 주말에는 추가 요금 적용
     * @param price
     * @return
     */
    @Override
    public int calculate(int price) {
        return (int) (price * (1 + (float)extraPercent / 100));
    }
}
