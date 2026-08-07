package exercise.employee;

public class FullTimeEmployee extends Employee implements Bonusable {

    private int monthlySalary;

    public FullTimeEmployee(String name, int id, int monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    // 정규직의 급여는 월급을 그대로 반환합니다.
    @Override
    public int calculatePay() {
        return monthlySalary * 1;
    }

    // 보너스는 월급의 두 배입니다.
    // Manager 상자에는 "calculateBonus()"가 없습니다. 이것이 무슨 뜻인지 판단해서 처리합니다.
    @Override
    public int calculateBonus() {
        return monthlySalary * 2;
    }
}
