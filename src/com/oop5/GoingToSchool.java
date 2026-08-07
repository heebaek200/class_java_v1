package com.oop5;

/**
 * 객체를 사용하고 실행해보는 테스트 코드
 */
public class GoingToSchool {

    // 메인 함수
    public static void main(String[] args) {
        Vehicle bus133 = new Bus(133);
        Vehicle bus57 = new Bus(57);
        Vehicle subway = new Subway(2);
        Student studentKim = new Student("김갑환", 10000);
        Student studentLee = new Student("이진주", 5000);

        // 버스
        studentKim.takeVehicle(bus133);
        studentLee.takeVehicle(bus133);

        System.out.println("＊학생의 현재 소지금 확인");
        studentKim.showInfo();

        System.out.println("＊버스의 상태 확인");
        bus133.showInfo();

        // 지하철
        studentLee.takeVehicle(subway);

        System.out.println("＊학생의 현재 소지금 확인");
        studentLee.showInfo();

        System.out.println("＊지하철의 상태 확인");
        subway.showInfo();


        // 식사
        System.out.println("＊＊＊＊＊＊＊＊＊＊＊");
        Rice rice = new Rice("잡곡밥", 3);
        studentKim.eatRice(rice);
        rice.showInfo();

    } // end of main

}
