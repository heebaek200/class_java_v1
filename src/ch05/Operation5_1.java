package ch05;

/**
 * 관계연산자
 *  연산의 결과는 true or false로 반환된다
 */
public class Operation5_1 {
    public static void main(String[] args) {

        int playerHealth = 50;      // 플레이어 체력
        int playerLevel = 10;       // 플레이어 레벨
        int enemyHealth = 30;       // 적 체력
        int enemyLevel = 15;        // 적 레벨

        // 1. 플레이어의 체력이 적 체력보다 높은지 확인하는 코드를 작성
        System.out.println("플레이어의 체력이 적 체력보다 높은가? : " + (playerHealth > enemyHealth));

        // 2. 플레이어 체력이 위험 수준인 20 이하인지 확인
        System.out.println("플레이어 체력이 위험 수준인 20 이하인지? : " + (playerHealth <= 20));

        // 3. 플레이어와 적의 체력이 같은지 확인
        System.out.println("플레이어와 적의 체력이 같은가? : " + (playerHealth == enemyHealth));

        // 4. 플레이어의 특정 레벨이 30 이상인지 확인
        System.out.println("플레이어의 특정 레벨이 30 이상인가? : " + (playerLevel >= 30));

    }
}
