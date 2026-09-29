package oop_test.ch05;

public class Item {

    // 아이템 이름
    private String name;
    // 아이템 등급
    private String grade;

    public Item(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

}
