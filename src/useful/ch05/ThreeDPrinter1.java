package useful.ch05;

public class ThreeDPrinter1 {

    // 재료
    Plastic material;

    // 재료를 꺼냄
    public Plastic getMaterial() {
        return material;
    }

    // 재료를 넣음
    public void setMaterial(Plastic material) {
        this.material = material;
    }


    // 테스트 코드 작성
    public static void main(String[] args) {
        Plastic plastic1 = new Plastic();
        ThreeDPrinter1 threeDPrinter1 = new ThreeDPrinter1();
        threeDPrinter1.setMaterial(plastic1);

        System.out.println("----------------");
        System.out.println(threeDPrinter1.getMaterial());

    }

}