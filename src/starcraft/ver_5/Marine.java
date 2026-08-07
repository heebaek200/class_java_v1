package starcraft.ver_5;

public class Marine extends Unit implements Healable {

    public Marine(String name) {
        super(name);

        super.attackPower = 6;
        super.healthPower = 40;
    }

    @Override
    public void regenarate() {
        super.healthPower = 40;
        System.out.println(this.name + " 유닛의 체력이 회복되었습니다.");
    }
}
