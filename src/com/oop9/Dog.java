package com.oop9;

public class Dog {

    private String name;
    private int age;
    private double weight;

    // getter

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }


    // setter

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) return;

        this.age = age;
    }

    public void setWeight(double weight) {
        if (weight < 0) return;

        this.weight = weight;
    }
}
