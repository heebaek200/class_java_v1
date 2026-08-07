package com.oop17;

public class Main {

    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[3];
        fruits[0] = new Banana();
        fruits[1] = new Peach();
        fruits[2] = new Apple();

        for (int i = 0; i < fruits.length; i++) {
            System.out.println("-----------------------");
            fruits[i].showInfo();

            // 방법A. Fruit 부모 클래스에 sale을 선언하여 어찌되었던 호출되도록 수정함
            fruits[i].sale();

            // 다른 방법B. sale메소드를 분리, interface를 구현하여 이를 통해 실행하기
            // 다른 방법C. 일단 실행하고 예외처리해버리기.
        }
    }
}
