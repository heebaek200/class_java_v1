package useful.ch06;

import java.util.ArrayList;

public class GenericPrinterMain {

    public static void main(String[] args) {

        // 제네릭 프로그래밍을 활용하면 타입의 안정성을 줘서 컴파일 시 명확하게 타입을 지정할 수 있다

        Plastic plastic1 = new Plastic();
        Powder powder1 = new Powder();

        GenericPrinter<Plastic> printer1 = new GenericPrinter();
        printer1.setMaterial(plastic1);
        System.out.println(printer1.getMaterial());     // 다운캐스팅 불필요

        // 컬렉션 프레임워크 ArrayList 사용해보기
        ArrayList<Integer> list = new ArrayList();
        list.add(10);
        list.add(11);
        // list.add(10.0); <- 오류 발생


    } // end of main

}
