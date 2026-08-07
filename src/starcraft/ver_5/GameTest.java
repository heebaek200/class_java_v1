package starcraft.ver_5;

// ver_4: 다형성 적용
// Unit의 attack메서드 오버로딩 -> 하나로 합체
// main의 호출부에서의 타입 선언 -> Unit으로 통일
public class GameTest {

    // 테스트 메인
    public static void main(String[] args) {

        Zealot zealot1 = new Zealot("김질럿");
        Zergling zergling1 = new Zergling("이저글링");
        Marine marine1 = new Marine("박마린");

        // 저글링이 버로우.
        System.out.println("------");
        zergling1.burrow();

        // 질럿이 저글링 한 번
        System.out.println("------");
        zealot1.attack(zergling1);

        // 마린이 질럿 여러번 공격
        System.out.println("------");
        for (int i = 0; i < 20; i++) {
            marine1.attack(zealot1);
        }

        // 저글링 상태
        System.out.println("------");
        zergling1.showInfo();

        // 질럿 상태
        zealot1.showInfo();


    } // 테스트 메인 종료

}
