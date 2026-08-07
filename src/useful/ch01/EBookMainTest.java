package useful.ch01;

public class EBookMainTest {

    public static void main(String[] args) {

        EBook eBook1 = new EBook(1, "홍길동전", "허균");
        EBook eBook2 = new EBook(1, "홍길동전", "허균");
        EBook eBook3 = new EBook(2, "춘향전", "작자미상");


        System.out.println("eBook1: + " + eBook1);
        System.out.println("eBook2: + " + eBook2);
        System.out.println("eBook3: + " + eBook3);

        System.out.println("-----------------------------------");

        System.out.println("eBook1 == eBook2: " + (eBook1 == eBook2));              // 참조비교
        System.out.println("eBook1.equal(eBook2): " + (eBook1.equals(eBook2)));     // 논리적 동등성 비교 (재정의된 equals 사용)
        System.out.println("eBook1.equal(eBook3): " + (eBook1.equals(eBook3)));

        System.out.println("eBook1.hashCode(): " + eBook1.hashCode());
        System.out.println("eBook2.hashCode(): " + eBook2.hashCode());              // eBook1과 해시코드 동일 (재정의된 hashCode 사용)
        System.out.println("eBook3.hashCode(): " + eBook3.hashCode());

    }

}
