package useful.ch07;

/**
 * <T extends 클래스>를 사용하면 특정 클래스를 상속받은 클래스만 대체 문자열에 들어올 수 있도록 범위 제한할 수 있다.
 */
public class GenericPrinter<T extends Meterial> {

    // 데이터 타입의 대체문자 선언. 단, 제네릭 클래스로 선언되어야 함
    T material;

    public T getMaterial() {
        return material;
    }

    public void setMaterial(T material) {
        this.material = material;
    }

    String string;

}
