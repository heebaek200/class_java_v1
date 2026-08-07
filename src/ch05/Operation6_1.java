package ch05;

/**
 * 관계연산자
 *  연산의 결과는 true or false로 반환된다
 */
public class Operation6_1 {
    public static void main(String[] args) {

        // 쇼핑몰 회원 정보
        int userAge = 20;
        int cartTotal = 5000;
        boolean isMember = true;
        int couponCount = 2;

        // 1. 무료 배송 조건: 장바구니 총액이 3만 원 이상이고 회원이어야 함
        boolean isFree = cartTotal >= 30000 && isMember;
        System.out.println("무료 배송 조건: " + isFree);

        // 2. 할인 조건: 나이가 19세 이상이거나 쿠폰이 1개 이상 있어야 함
        boolean canDiscount = userAge >= 19 || couponCount >= 1;
        System.out.println("할인 조건: " + canDiscount);

        // 3. 구매 제한 조건: 나이가 19세 미만이고 회원이 아닌 경우
        boolean cannotBuy = userAge < 19 && !isMember;
        System.out.println("구매 제한 조건: " + cannotBuy);

        // 4. 이벤트 참여 조건: 장바구니 총액이 5만 원 미만이거나 쿠폰이 3개 미만
        boolean canJoinEvent = cartTotal < 50000 || couponCount < 3;
        System.out.println("이벤트 참여 조건: " + canJoinEvent);

    }
}
