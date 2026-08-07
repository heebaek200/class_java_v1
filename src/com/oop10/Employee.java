package com.oop10;

public class Employee {

    private int employeeNumber; // 고유 사원번호
    private String name;
    private String department;  // 부서


    public Employee(String name, String department) {
        this.name = name;
        this.department = department;

        // 직원 객체를 생성할 때 마다 자동으로 Company의 시리얼 번호를 활용해서 자동 할당
        this.employeeNumber = Company.empSerialNumber++;

    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}
