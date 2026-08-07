package com.oop4;

public class CoffeeMachineTest {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine2 = new CoffeeMachine();
        coffeeMachine2.water = 600;
        coffeeMachine2.coffee = 400;
        coffeeMachine2.showCount();

        System.out.println("----------------------------");

        CoffeeMachine coffeeMachine = new CoffeeMachine(200, 400);

        coffeeMachine.makeCoffee();

        coffeeMachine.refillWater(200);
        coffeeMachine.refillCoffee(100);

        coffeeMachine.makeCoffee();
        coffeeMachine.makeCoffee();
        coffeeMachine.makeCoffee();
        coffeeMachine.makeCoffee();
        coffeeMachine.makeCoffee();
        coffeeMachine.makeCoffee();
        coffeeMachine.makeCoffee();
        coffeeMachine.makeCoffee();

        coffeeMachine.showInfo();

        coffeeMachine.showCount();
    }
}
