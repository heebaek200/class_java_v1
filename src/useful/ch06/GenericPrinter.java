package useful.ch06;

/**
 * 제네릭 프로그래밍
 *  문법: <T> 대체 문자열 선언
 */
public class GenericPrinter<T> {

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
