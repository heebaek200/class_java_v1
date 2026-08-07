package starcraft.ver_2;

public class Marine {

    private String name;
    private int attackPower;
    private int healthPower;

    public Marine(String name) {
        this.name = name;

        this.attackPower = 6;
        this.healthPower = 40;
    }

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getHealthPower() {
        return healthPower;
    }

    // 1. 마린이 질렁을 공격합니다.
    public void attack(Zealot zealot) {
        if (isFalled()) {
            System.out.println(this.name + " 유닛이 쓰러져있어 공격할 수 없습니다.");
            return;
        }

        System.out.println(this.name + " 유닛이 공격합니다.");
        zealot.beAttacked(attackPower);
    }

    // 2. 마린이 저글링을 공격합니다.
    public void attack(Zergling zergling) {
        if (isFalled()) {
            System.out.println(this.name + " 유닛은 이미 쓰러진 상태입니다.");
            return;
        }

        System.out.println(this.name + " 유닛이 공격합니다.");
        zergling.beAttacked(attackPower);
    }

    // 3. 자기 자신(마린)이 공격을 당합니다.
    public void beAttacked(int ememyAttackPower) {
        this.healthPower -= ememyAttackPower;
        System.out.println(this.name + " 유닛이 공격을 당합니다. 남은 체력 : " + healthPower);

        if (isFalled()) {
            System.out.println(this.name + " 유닛이 쓰러졌습니다.💀💀💀💀💀️");
        }
    }

    // 이 유닛이 쓰러진 것인지 판단
    public boolean isFalled() {
        return healthPower <= 0;
    }

    // 4. 내 현재 상태 콘솔 출력
    public void showInfo() {
        System.out.println("----- 상태창 -----");
        System.out.println("이름: "        + name);
        System.out.println("현재 공격력: " + attackPower);
        System.out.println("현재 체력: "   + healthPower);
        System.out.println("이 유닛의 쓰러진 상태: "   + isFalled());
    }
}
