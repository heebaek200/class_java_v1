package exercise.customer;

// 도전 과제 - 상속을 활ㅇ용한 멤버십 클래스 구현하기
public class Customer {

    private int customerID;
    private String customerName;
    private String customerGrade;
    private int bonusPoint;
    private double bonusRatio;


    public Customer() {
    }

    public int calcPrice(int price) {

        return price;
    }

    public String showCustomerInfo() {
        return "msg";
    }
}
