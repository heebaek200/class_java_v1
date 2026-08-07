package exercise.employee;

public class EmployeeMain {

    public static void main(String[] args) {

        Employee employee1 = new FullTimeEmployee("김정규", 1001, 3200000);
        Employee employee2 = new PartTimeEmployee("이알바", 2001, 80, 10030);
        Employee employee3 = new Manager("박팀장", 1002, 4000000, 500000);

        employee1.printInfo();
        System.out.println("--------");
        employee2.printInfo();
        System.out.println("--------");
        employee3.printInfo();



    }

}
