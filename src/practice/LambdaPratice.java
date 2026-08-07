package practice;

public class LambdaPratice {

    public static void main(String[] args) {
//        // Lambda expression: 객체 지향 언어인 자바에 절차형 프로그래밍 요소를 넣어 간결하게 표현하는 것을 돕기 위해 지원되었다.
//
//        // 람다식 문법으로 표현
//        (x, y) -> {return x+y;}
//
//        // 람다식은 다음과 같은 생략 표현이 가능하다.
//        // 매개 변수가 한 개일 경우에 한해 소괄호를 생략할 수 있다.
//        str -> {System.out.println(str);}
//        // 구현부가 한 문장이거나 return 타입이 void라면 중괄호를 생략할 수 있다.
//        str -> System.out.println(str);
//        // return 문만 존재하는 구현부는 중괄호과 return을 모두 생략할 수 있다.
//        (x, y) -> x + y;
//
//        // 자바는 사용방법이 엄격하고 제한적이라는 점이 좋은 결과를 만들어내는 언어인데, 차칫 너무 풀어준게 아닐까?
    }

    // 기본적인 메서드
    int add(int x, int y) {
        return x + y;
    }

}
