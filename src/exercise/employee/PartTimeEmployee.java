package exercise.employee;

public class PartTimeEmployee extends Employee {

    private int hourlyWage;
    private int workHours;

    public PartTimeEmployee(String name, int id, int hourlyWage, int workHours) {
        super(name, id);
        this.hourlyWage = hourlyWage;
        this.workHours = workHours;
    }

    // 아르바이트의 급여는 시급 곱하기 근무 시간입니다.
    @Override
    public int calculatePay() {
        return hourlyWage * workHours;
    }

    // PartTimeEmployee의 "printInfo()"는 부모의 출력에 근무 시간을 덧붙입니다.
    @Override
    public void printInfo() {
        super.printInfo();
        //System.out.printf("[%d] %s\n", getId(), getName());
        System.out.printf("이번 달 근무 시간 : %d시간\n", hourlyWage);
        //System.out.printf("급여 : %d원\n", calculatePay());
    }
}
