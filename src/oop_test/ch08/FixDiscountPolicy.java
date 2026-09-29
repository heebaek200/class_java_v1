package oop_test.ch08;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountAmount = 1_000;

    @Override
    public int discount(int price) {
        return discountAmount;
    }

}
