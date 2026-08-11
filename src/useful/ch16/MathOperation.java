package useful.ch16;

// 함수형 인터페이스. 단 하나의 추상 메서드를 가지도록 강제함.

@FunctionalInterface
interface MathOperation {
    int operate(int x, int y);

    //void run();       // 함수형 인터페이스는 2번째 추상 메서드는 불가
}