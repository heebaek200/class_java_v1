package useful.ch09;

/**
 *  내부 클래스의 4가지 종류
 *      2. 정적 멤버 내부 클래스
 *
 */
public class OuterClass2 {

    private static int num = 10;

    // 2. 정적 멤버 내부 클래스
    static class InnerClass {

        public void display() {
            System.out.println("num(2) : " + OuterClass2.num);
        }

    }

    public static void main(String[] args) {

        OuterClass2.InnerClass inner = new OuterClass2.InnerClass();
        inner.display();

    }


} // end of outer class
