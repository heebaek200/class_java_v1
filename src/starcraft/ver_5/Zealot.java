package starcraft.ver_5;

public class Zealot extends Unit implements Healable, ShieldChargeable {

    private int shieldPower;

    public Zealot(String name) {
        super(name);

        super.attackPower = 16;
        super.healthPower = 60;
        this.shieldPower = 100;
    }


    @Override
    public void regenarate() {
        super.healthPower = 40;
        System.out.println(this.name + " 유닛의 체력이 회복되었습니다.");
    }

    @Override
    public void chargeShieldPower(int amount) {
        this.shieldPower = 100;
        System.out.println(this.name + " 유닛의 실드가 모두 회복되었습니다.");
    }

    @Override
    public int getShieldPower() {
        return this.shieldPower;
    }

    @Override
    public void reduceShieldPower(int amount) {

    }

    @Override
    public void beAttacked(int ememyAttackPower) {
        int reduceHp = 0;       // 방어막 초과 피해량
        this.shieldPower -= ememyAttackPower;
        if (this.shieldPower < 0) {
            reduceHp = -this.shieldPower;
            this.shieldPower = 0;
        }
        System.out.println(this.name + " 유닛의 남은 보호막 : " + shieldPower);

        if (reduceHp > 0) {
            super.beAttacked(ememyAttackPower);
        }
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("현재 보호막: "   + shieldPower);
    }
}
