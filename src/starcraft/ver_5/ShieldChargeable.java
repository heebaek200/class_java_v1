package starcraft.ver_5;

public interface ShieldChargeable {

    public void chargeShieldPower(int amount);       // 보호막 충전
    public int getShieldPower();                     // getter of shield
    public void reduceShieldPower(int amount);       // 피해를 받았을 때 보호막 감소

}
