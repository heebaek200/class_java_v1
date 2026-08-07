package practice.poke;

public class Monster {

    private String monsterName;

    public Monster(String monsterName) {
        this.monsterName = monsterName;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void fight() {
        System.out.println(monsterName + " 는 전투에 참가했다.");
    }

    public void showInfo() {
        System.out.println(monsterName + " 한 마리 보관 중...");
    }
}
