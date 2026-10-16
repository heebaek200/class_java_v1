package design.adapter;

public class MyHouse {

    // 220v 콘센트에 전자기기를 연결하는 메서드를 가지고 있음
    public static void plugIn(IElectronic220v device) {
        device.connect();
    }

    // 테스트 코드
    public static void main(String[] args) {
        Cleaner cleaner = new Cleaner();
        HairDryer hairDryer = new HairDryer();

        plugIn(cleaner);
        // plugIn(hairDryer);  // 규격 안맞어서 안됨

        // 과제
        plugIn(new EletronicAdapter(hairDryer));
    }

}
