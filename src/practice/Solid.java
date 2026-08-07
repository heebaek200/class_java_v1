package practice;

// 결제 기능 만을 담당하는 인터페이스: 아래 원칙을 적용한다.
// 단일 책임 원칙 (SRP)
// 인터페이스 분리 원칙 (ISP)
interface PaymentProc {
    void procPayment(int amount);
}

// 환불 기능 만을 담당하는 인터페이스
interface RefundableProc {
    void procRefund(int amount);
}

// 신용카드 결제를 위한 클래스: 아래 원칙을 적용한다.
// 새로운 결제 수단이 추가되어도 확장만 하며, 기존 코드를 수정하지 않는다.
// 개방-폐쇄 원칙 (OCP)
class CreditcardProc implements PaymentProc, RefundableProc {
    @Override
    public void procPayment(int amount) {
        System.out.println("신용카드로 " + amount + "원 결제 완료");
    }

    @Override
    public void procRefund(int amount) {
        System.out.println("신용카드로 " + amount + "원 환불 완료");
    }
}

// 카카오페이 결제를 위한 클래스
class KakaoPayProc implements PaymentProc {
    @Override
    public void procPayment(int amount) {
        System.out.println("카카오페이로 " + amount + "원 결제 완료");
    }

    // 이 결제수단은 환불을 지원하지 않는다. 인터페이스 분리 원칙 (ISP)에 의하여 빈 메서드를 만들지 않아도 된다.
}

// 상점 클래스: 아래 원칙을 적용한다. 각 결제수단이 아닌 인터페이스에 의존한다.
// 의존 역전 원칙 (DIP)
class Store {
    private final PaymentProc paymentProc;

    public Store (PaymentProc paymentProc) {
        this.paymentProc = paymentProc;
    }

    public void purchase(int amount) {
        // 결제 수행
        paymentProc.procPayment(amount);
    }
}

// 실행 및 리스코프 치환 원칙 확인
public class Solid {
    public static void main(String[] args) {
        // LSP: PaymentProc 자리에 어떤 하위 구현체를 넣어도 Store는 아무 문제 없이 작동함
        PaymentProc card = new CreditcardProc();
        Store store1 = new Store(card);
        store1.purchase(10000);

        PaymentProc kakao = new KakaoPayProc();
        Store store2 = new Store(kakao);
        store2.purchase(5000);
    }
}