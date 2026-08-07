package starcraft.ver_2;

public class GameTest {

    // 테스트 메인
    public static void main(String[] args) {

        Zealot zealot1     = new Zealot("김질럿");
        Zergling zergling1 = new Zergling("이저글링");
        Marine marine1     = new Marine("박마린");


        // 질럿이 저글링 한 번
        System.out.println("------");
        zealot1.attack(zergling1);

        // 저글링이 마린 한 번
        System.out.println("------");
        zergling1.attack(marine1);

        // 마린이 질럿 한 번
        System.out.println("------");
        marine1.attack(zealot1);

        // 질럿이 저글링 한 번
        System.out.println("------");
        zealot1.attack(zergling1);

        // 질럿이 저글링 한 번
        System.out.println("------");
        zealot1.attack(zergling1);

        // 저글링이 질럿 한 번
        System.out.println("------");
        zergling1.attack(zealot1);

        // 저글링 상태
        zergling1.showInfo();


    } // 테스트 메인 종료

}
