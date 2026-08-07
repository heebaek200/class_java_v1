package com.oop7;

import java.util.Scanner;

public class GoingToSchoolMenu {

    final static int EAT     = 1;
    final static int BUS     = 2;
    final static int SUBWAY  = 3;
    final static int MY_INFO = 4;
    final static int END     = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("학생의 이름을 입력하세요: ");
        String name = sc.nextLine();

        // 객체 생성 (등장 인물 준비)
        Student student = new Student(name, 5_000);
        Rice rice = new Rice("김치볶음밥", 3_000);
        Bus bus133 = new Bus(133, 1_000);
        Subway line1 = new Subway(1, 1_400);

        while (true) {
            System.out.println();
            System.out.println("메뉴 선택");
            System.out.println("1: 밥 먹기, 2: 버스 타기, 3: 지하철 타기, 4: 내 정보, 0: 종료");

            if (sc.hasNextInt()) {

                int menu = sc.nextInt();

                switch (menu) {
                    case EAT -> {
                        // 쌀먹
                        student.eatRice(rice);
                    }
                    case BUS -> {
                        // 버스타기
                        student.rideVehicle(bus133);
                    }
                    case SUBWAY -> {
                        // 지하철타기
                        student.rideVehicle(line1);
                    }
                    case MY_INFO -> {
                        // 내 정보
                        student.showInfo();
                    }
                    case END -> {
                        // do not anything
                    }
                    default -> {
                        System.out.println("존재하지 않는 메뉴를 선택했습니다.");
                        continue;
                    }
                }

                if (menu == END) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

            } else {
                System.out.println("정수값을 입력해주세요!");
                sc.next();
                continue;
            }


        }

        sc.close();

    }

}
