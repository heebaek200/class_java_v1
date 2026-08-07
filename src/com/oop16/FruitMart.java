package com.oop16;

public class FruitMart {

    public static void main(String[] args) {

        // 다형성의 활용 - 하나의 배열에 여러 타입 담기
        Banana[] bananas = new Banana[10];
        bananas[0] = new Banana();
        bananas[1] = new Banana();

        Peach[] peaches = new Peach[3];
        peaches[0] = new Peach();
        peaches[1] = new Peach();
        peaches[2] = new Peach();

        // 결론: 다형성이 없다면 타입별 배열을 따로 만들어야 함.
        // 다형성을 쓰면 부모 타입 배열 하나에 자식들을 모두 담을 수 있다.
        Fruit[] fruits = new Fruit[4];
        fruits[0] = new Banana();
        fruits[1] = new Peach();
        fruits[2] = new Banana();
        fruits[3] = new Apple();

        for (int i = 0; i < fruits.length; i++) {
            System.out.println("-----------------------");
            fruits[i].showInfo();

            // 문제: 타입이 바나나일 때만 할일 메서드를 호출하시오.
            if (fruits[i] instanceof Banana){
                ((Banana) fruits[i]).saleBanana();
            } else if (fruits[i] instanceof Apple){
                ((Apple) fruits[i]).saleApple();
            }
        }

        // ↑ 확장해서... 이 코드도 좋지 않은 이유


    }

}
