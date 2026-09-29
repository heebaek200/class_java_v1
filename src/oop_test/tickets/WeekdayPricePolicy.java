package oop_test.tickets;

public class WeekdayPricePolicy implements PricePolicy {

    private int discountAmount = 1_000;

    /**
     * 평일 할인 적용
     * @param price
     * @return
     */
    @Override
    public int calculate(int price) {
        return price - discountAmount >= 0 ? price - discountAmount : 0;
    }
}
