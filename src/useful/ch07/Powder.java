package useful.ch07;

public class Powder extends Meterial {

    @Override
    public String toString() {
        return "재료는 파우더입니다.";
    }

    @Override
    public void showInfo() {
        System.out.println("고체 물질을 잘게 빻거나 갈아서 자유롭게 흘러내리는 미세한 입자 상태로 만든 가루(분말)");
    }
}
