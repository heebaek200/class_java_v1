package com.oop4;

public class CoffeeMachine {

    // 필드: 물의 양(ml), 원두 양(g)
    int water;
    int coffee;

    // 필드: 제작한 커피 잔 수
    int count;

    final int REQUIRED_WATER_FOR_SHOT = 100;    // 커피 한 잔에 필요한 물의 양 100ml
    final int REQUIRED_COFFEE_FOR_SHOT = 10;    // 커피 한 잔에 필요한 원두의 양 10g

    // 생성자1
    // 생성자 내부에서 setter 사용을 하면 안 좋은 이유:
    // 생성자 내부에서 setter를 사용하면 상속 시 오버라이드 위험, 불변성 파괴, 예측 불가능한 부수 효과 문제가 생깁니다.
    //  고찰: 생성자와 setter의 내용이 매우 유사한 경우엔 어떤 식으로 작성하는 것을 좋을까?
    //   방법1. 공통 로직을 private 메서드로 분리. 추천 방법.
    //   방법2. final 키워드로 Setter 오버라이드 금지시키기.
    //   방법3. 불변(Immutable) 객체로 만들고 빌더(Builder) 사용하기. 트렌디함.
    public CoffeeMachine() {
        water = 0;
        coffee = 0;

        count = 0;
    }

    // 생성자2
    // 초기 물 채우기, 커피 채우기 진행하는 생성자
    public CoffeeMachine(int amountWater, int amountCoffee) {
        if (amountWater > 0) {
            water += amountWater;
            System.out.println(amountWater + " ml의 물을 채웠습니다.");
        } else {
            System.out.println("0 보다 큰 양의 물을 채워주세요.");
        }

        if (amountCoffee > 0) {
            coffee += amountCoffee;
            System.out.println(amountCoffee + " g의 원두를 채웠습니다.");
        } else {
            System.out.println("0 보다 큰 양의 원두를 채워주세요.");
        }

        count = 0;
    }

    // 메서드1: 물 채우기
    void refillWater(int amount) {
        if (amount > 0) {
            water += amount;
            System.out.println(amount + " ml의 물을 채웠습니다.");
        } else {
            System.out.println("0 보다 큰 양의 물을 채워주세요.");
        }
    }

    // 메서드2: 원두 채우기
    void refillCoffee(int amount) {
        if (amount > 0) {
            coffee += amount;
            System.out.println(amount + " g의 원두를 채웠습니다.");
        } else {
            System.out.println("0 보다 큰 양의 원두를 채워주세요.");
        }
    }

    // 메서드3: 커피 만들기
    void makeCoffee() {
        if (water >= REQUIRED_WATER_FOR_SHOT && coffee >= REQUIRED_COFFEE_FOR_SHOT) {
            water -= REQUIRED_WATER_FOR_SHOT;
            coffee -= REQUIRED_COFFEE_FOR_SHOT;
            count++;
            System.out.println("커피 한 잔!");
        } else {
            System.out.println("재료가 부족합니다. 물과 원두를 채워주세요.");

        }
    }

    // 메서드4. 해당하는 객체의 현재 상태값을 보여주는 기능 추가 (콘솔 창)
    void showInfo() {
        System.out.println("현재 물의 양 : " + water + " ml");
        System.out.println("현재 원두의 양 : " + coffee + " g");
    }

    // 메서드5. 현재 해당하는 커피 머신이 몇 잔의 커피를 만들었는지 출력하는 기능을 만들어주세요.
    void showCount() {
        System.out.println("이 커피 머신은 총 " + count + " 잔의 커피를 만들었습니다.");
    }

}
