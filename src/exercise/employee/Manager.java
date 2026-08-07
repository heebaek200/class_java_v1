package exercise.employee;

public class Manager extends FullTimeEmployee {
    private int allowance;

    public Manager(String name, int id, int monthlySalary, int allowance) {
        super(name, id, monthlySalary);
        this.allowance = allowance;
    }

    // 팀장의 급여는 월급에 직책 수당을 더한 금액입니다. 이때 월급 부분은 부모의 계산을 재사용합니다.
    @Override
    public int calculatePay() {
        return super.calculatePay() + allowance;
    }

    // 팀장의 "printInfo()"는 부모의 출력에 직책 수당을 한 줄 덧붙입니다.
    @Override
    public void printInfo() {
        super.printInfo();
        //System.out.printf("[%d] %s\n", getId(), getName());
        System.out.printf("직책수당 : %d원\n", allowance);
        //System.out.printf("급여 : %d원\n", calculatePay());
        System.out.printf("보너스 : %d원\n", calculateBonus());
    }
}
