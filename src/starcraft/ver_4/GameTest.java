package starcraft.ver_4;

// ver_4: 다형성 적용
// Unit의 attack메서드 오버로딩 -> 하나로 합체
// main의 호출부에서의 타입 선언 -> Unit으로 통일
public class GameTest {

    // 테스트 메인
    public static void main(String[] args) {

        Unit zealot1   = new Zealot("김질럿");
        Unit zergling1 = new Zergling("이저글링");
        Unit marine1   = new Marine("박마린");


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
