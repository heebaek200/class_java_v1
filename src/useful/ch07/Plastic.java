package useful.ch07;

public class Plastic extends Meterial {

    @Override
    public String toString() {
        return "재료는 플라스틱입니다.";
    }

    @Override
    public void showInfo() {
        System.out.println("열이나 압력을 주어 원하는 모양으로 쉽게 바꿀 수 있는 합성수지(고분자 화합물), 가소성이 있는(변형하기 쉬운) 상태, 또는 가짜나 인공적인 것");
    }

}
