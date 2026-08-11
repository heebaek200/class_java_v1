package useful.ch16;


// 도전과제
// 두 수를 입력 받아 큰 값을 출력하는 기능을 만들어보세요. 단, 람다 표현식을 사용하세요.

public class Practice1 {

    // 1. 함수형 인터페이스 선언
    @FunctionalInterface
    public interface Calculator {
        int operate(int x, int y);
    }

    public static void main(String[] args) {

        // 2. 람다 표현식 설계
        Calculator maxCalc = (x, y) -> x > y ? x : y;

        // 3. 데이터 입력 후 결과 확인
        int x = 10; int y = 50;
        System.out.printf("%d 와 %d 중에 더 큰 값은? %d", x, y, maxCalc.operate(x, y));

    }

}
