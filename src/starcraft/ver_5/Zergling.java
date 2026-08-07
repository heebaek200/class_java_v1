package starcraft.ver_5;

public class Zergling extends Unit implements Healable, Burrowable {

    private boolean burrowed = false;

    public Zergling(String name) {
        super(name);

        super.attackPower = 5;
        super.healthPower = 35;
    }

    @Override
    public void regenarate() {
        super.healthPower = 40;
        System.out.println(this.name + " 유닛의 체력이 회복되었습니다.");
    }

    @Override
    public void burrow() {
        System.out.println(this.name + " 유닛이 버로우했습니다.");
        burrowed = true;
    }

    @Override
    public void unburrow() {
        System.out.println(this.name + " 유닛이 버로우를 풀었습니다.");
        burrowed = false;
    }

    @Override
    public void beAttacked(int ememyAttackPower) {
        if (this.burrowed) {
            System.out.println(this.name + " 유닛이 버로우되어 있어 공격받지 않습니다.");
        } else {
            super.beAttacked(ememyAttackPower);
        }
    }

    @Override
    public void attack(Unit unit) {
        if (this.burrowed) {
            System.out.println(this.name + " 유닛이 버로우되어 있어 공격할 수 없습니다.");
        } else {
            super.attack(unit);
        }
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("현재 버로우 상태: " + burrowed);
    }
}
