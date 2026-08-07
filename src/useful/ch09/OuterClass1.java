package useful.ch09;

/**
 * 내부 클래스(Inner Class)란?
 *  한 클래스 내부에 선언된 클래스를 말한다.
 *  외부 클래스와 연관이 있고, 다른 곳에서 거의 사용할 일이 없을 경우 사용하기도 한다.
 *
 *  내부 클래스의 4가지 종류
 *      1. 멤버 내부 클래스
 *
 */
public class OuterClass1 {

    private int num = 10;

    // 1. 멤버 내부 클래스
    class InnerClass {
        public void display() {
            System.out.println("num : " + OuterClass1.this.num);
        }
    } // end of inner class

    public static void main(String[] args) {
        // 내부 클래스가 일반 멤버 클래스로 설계된 경우, 외부 클래스가 먼저 객체로 생성된 후 내부 클래스를 생성할 수 있다.
        OuterClass1 outerClass1 = new OuterClass1();
        OuterClass1.InnerClass innerClass = outerClass1.new InnerClass();
        innerClass.display();
    }

} // end of outer class
