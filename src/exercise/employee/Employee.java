package exercise.employee;

public abstract class Employee implements Payable {

    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // "printInfo()"는 사번과 이름을 출력합니다.
    public void printInfo() {
        System.out.printf("[%d] %s\n", getId(), getName());
        System.out.printf("급여 : %d원\n", calculatePay());
    }
}
