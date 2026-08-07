package ch03;

public class ConstantTest1 {

    // 코드 실행의 시작점
    public static void main(String[] args) {

        // Variable
        int num = 10;
        num = 101;

        // Constant
        // final 키워드 사용, 변수명은 대문자_를 사용하는 권장 사항
        final int MAX_NUM = 100;
        // MAX_NUM = 1; // 불가

        // 원주율을 상수로 선언해 보자
        final double PI = Math.PI; // 3.14159;

        System.out.println(PI);

        // 1. 넓이(Area)로 반지름 구하기
        double area = 78.53981633974483;
        double radiusFromArea = Math.sqrt(area / PI);
        System.out.println("넓이가 " + area + "일 때 반지름: " + radiusFromArea);

        // 2. 둘레(Circumference)로 반지름 구하기
        double circumference = 31.41592653589793;
        double radiusFromCircumference = circumference / (2 * PI);
        System.out.println("둘레가 " + circumference + "일 때 반지름: " + radiusFromCircumference);

        // 반지름 지정 (예: 5.0)
        double radius = 5.0;

        // 3. 원의 넓이 구하기 (공식: 반지름 * 반지름 * π)
        double area2 = radius * radius * PI;
        System.out.println("반지름이 " + radius + "일 때 넓이: " + area2);

        // 4. 원의 둘레 구하기 (공식: 2 * π * 반지름)
        double circumference2 = 2 * PI * radius;
        System.out.println("반지름이 " + radius + "일 때 둘레: " + circumference2);


    } // end of main

} // end of class
