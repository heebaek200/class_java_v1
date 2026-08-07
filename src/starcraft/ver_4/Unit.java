package starcraft.ver_4;

public class Unit {

    protected String name;
    protected int attackPower;
    protected int healthPower;

    public Unit(String name) {
        this.name = name;

        this.attackPower = 0;
        this.healthPower = 0;
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


    // 유닛을 공격합니다.
    public void attack(Unit unit) {
        if (isFalled()) {
            System.out.println(this.name + " 유닛이 쓰러져있어 공격할 수 없습니다.");
            return;
        }

        System.out.println(this.name + " 유닛이 공격합니다.");
        unit.beAttacked(attackPower);
    }


    // 공격을 당합니다.
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
